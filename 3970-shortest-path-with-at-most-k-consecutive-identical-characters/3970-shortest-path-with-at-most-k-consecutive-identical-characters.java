class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        java.util.List<java.util.List<int[]>> graph =
            new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new java.util.ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int same = labels.charAt(u) == labels.charAt(v) ? 1 : 0;
            graph.get(u).add(new int[]{v, w, same});
        }

        int[] done = new int[n];
        java.util.Arrays.fill(done, k + 1);

        java.util.PriorityQueue<long[]> heap =
            new java.util.PriorityQueue<>((a, b) -> {
                int cmp = Long.compare(a[0], b[0]);
                if (cmp != 0) return cmp;

                cmp = Long.compare(a[1], b[1]);
                if (cmp != 0) return cmp;

                return Long.compare(a[2], b[2]);
            });

        heap.offer(new long[]{0, 0, 1});

        while (!heap.isEmpty()) {
            long[] current = heap.poll();
            long d = current[0];
            int u = (int) current[1];
            int r = (int) current[2];

            if (r >= done[u]) continue;
            done[u] = r;

            if (u == n - 1) return (int) d;

            for (int[] e : graph.get(u)) {
                int v = e[0], w = e[1];
                int nr = e[2] == 1 ? r + 1 : 1;

                if (nr < done[v]) {
                    heap.offer(new long[]{d + w, v, nr});
                }
            }
        }

        return -1;
    }
}