class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD = 1_000_000_007;
        int n = grid.length;
        int m = grid[0].length;
        long[][] dp= new long[m+1][2];
        dp[1][0] =1;
        dp[1][1] =1;
        for(int i=0; i <n;i++){
            for(int j =0; j <m;j++){
                if(grid[i][j] == 1){
                    long next0 = dp[j+1][1];
                    long next1= dp[j][0];
                    dp[j+1][0] = next0;
                    dp[j+1][1] = next1;
                }
                else {
                    long val = (dp[j+1][1] + dp[j][0])%MOD;
                    dp[j+1][0] = val;
                    dp[j+1][1] = val;
                }
            }
        }
        return (int)dp[m][0];
        
    }
}