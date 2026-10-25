class Solution {
    void dfs(int grid[][],int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1)return ;
        int stps[][]={{0,1},{1,0},{0,-1},{-1,0}};
        grid[i][j]=1;
        for(int k[]:stps){
            dfs(grid,i+k[0],j+k[1]);
        }
    }
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length-1);
        }
        for(int j=0;j<grid[0].length;j++){
            dfs(grid,0,j);
            dfs(grid,grid.length-1,j);
        }
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;
    }
} 
