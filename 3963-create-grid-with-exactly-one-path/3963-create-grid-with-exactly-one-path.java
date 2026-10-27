class Solution {
    public String[] createGrid(int p, int q) {
        char[][] g6 = new char[p][q];

        
        for (int i = 0; i < p; i++) {
            Arrays.fill(g6[i], '#');
        }

    
        for (int j = 0; j < q; j++) {
            g6[0][j] = '.';
        }

        
        for (int i = 0; i < p; i++) {
            g6[i][q - 1] = '.';
        }

        String[] ans2 = new String[p];
        for (int i = 0; i < p; i++) {
            ans2[i] = new String(g6[i]);
        }

        return ans2;
    }
}