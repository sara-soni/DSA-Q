import java.util.Arrays;

class Solution {
    private int[] head;
    private int[] next;
    private int[] to;
    private int edgeIdx = 0;

    private int[] lastSeen;
    private int[] ans;
    private char[] chars;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        chars = s.toCharArray();
        ans = new int[n];
        
        // Flat array adjacency list
        head = new int[n];
        Arrays.fill(head, -1);
        next = new int[n];
        to = new int[n];

        for (int i = 1; i < n; i++) {
            addEdge(parent[i], i);
        }

        // Tracks the deepest ancestor seen so far for each character ('a'-'z')
        lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        dfs(0, -1);
        return ans;
    }

    private void addEdge(int u, int v) {
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    private void dfs(int u, int p) {
        int c = chars[u] - 'a';
        int prevAncestor = lastSeen[c];

        // Update the most recent node with character c to the current node
        lastSeen[c] = u;
        ans[u] = 1;

        for (int e = head[u]; e != -1; e = next[e]) {
            dfs(to[e], u);
        }

        // Restore the previous ancestor before leaving u's subtree
        lastSeen[c] = prevAncestor;

        // Attach u's final subtree size to its new parent (or original parent p)
        if (p != -1) {
            int targetParent = (prevAncestor != -1) ? prevAncestor : p;
            ans[targetParent] += ans[u];
        }
    }
}