class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] order = new int[n];

        Arrays.fill(parent, -1);
        parent[0] = 0;
        order[0] = 0;
        int orderSize = 1;

        for (int i = 0; i < orderSize; i++) {
            int u = order[i];

            for (int v : g.get(u)) {
                if (v != parent[u]) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    order[orderSize++] = v;
                }
            }
        }

        int[] size = new int[n];
        int[] heavy = new int[n];
        Arrays.fill(size, 1);
        Arrays.fill(heavy, -1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[u];

            size[p] += size[u];

            if (heavy[p] == -1 || size[u] > size[heavy[p]]) {
                heavy[p] = u;
            }
        }

        int[] head = new int[n];
        int[] pos = new int[n];
        int[] stack = new int[n];

        int top = 0;
        int cur = 0;
        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            int h = u;

            while (u != -1) {
                head[u] = h;
                pos[u] = cur++;

                for (int v : g.get(u)) {
                    if (v != parent[u] && v != heavy[u]) {
                        stack[top++] = v;
                    }
                }

                u = heavy[u];
            }
        }

        int size2 = 1;
        while (size2 < n) {
            size2 <<= 1;
        }

        int[] seg = new int[2 * size2];

        for (int u = 0; u < n; u++) {
            seg[size2 + pos[u]] = 1 << (s.charAt(u) - 'a');
        }

        for (int i = size2 - 1; i > 0; i--) {
            seg[i] = seg[i * 2] ^ seg[i * 2 + 1];
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.trim().split("\\s+");
            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);
                update(seg, size2, pos[u], 1 << (c - 'a'));
            } else {
                int v = Integer.parseInt(parts[2]);
                int mask = pathQuery(
                    seg, size2, parent, depth, head, pos, u, v
                );

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void update(int[] seg, int size2, int p, int value) {
        p += size2;
        seg[p] = value;

        for (p >>= 1; p > 0; p >>= 1) {
            seg[p] = seg[p * 2] ^ seg[p * 2 + 1];
        }
    }

    private int rangeQuery(int[] seg, int size2, int l, int r) {
        l += size2;
        r += size2;
        int res = 0;

        while (l <= r) {
            if ((l & 1) != 0) {
                res ^= seg[l++];
            }

            if ((r & 1) == 0) {
                res ^= seg[r--];
            }

            l >>= 1;
            r >>= 1;
        }

        return res;
    }

    private int pathQuery(
        int[] seg,
        int size2,
        int[] parent,
        int[] depth,
        int[] head,
        int[] pos,
        int u,
        int v
    ) {
        int res = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            res ^= rangeQuery(seg, size2, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        return res ^ rangeQuery(seg, size2, pos[u], pos[v]);
    }
}