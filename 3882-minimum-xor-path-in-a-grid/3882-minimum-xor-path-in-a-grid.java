class Solution {
    class Pair{
        int row;
        int col;
        int val;
        Pair(int row,int col,int val){
            this.row=row;
            this.col=col;
            this.val=val;
        }
    }
    public int minCost(int[][] grid) {
        int n=grid.length,m=grid[0].length,min=Integer.MAX_VALUE;
        Queue<Pair>queue=new LinkedList<>();
        queue.offer(new Pair(0,0,grid[0][0]));
        boolean[][][]visited=new boolean[n][m][1024];
        visited[0][0][grid[0][0]]=false;
        for(boolean[][]row1:visited){
            for(boolean[]row:row1){
                Arrays.fill(row,false);
            }
        }
        int[]allowedRow={0,1};
        int[]allowedCol={1,0};
        while(!queue.isEmpty()){
            Pair cur=queue.poll();
            if(cur.row==n-1&&cur.col==m-1){
                if(cur.val<min)min=cur.val;
                visited[cur.row][cur.col][cur.val]=false;
                continue;
            }
            for(int i=0;i<2;i++){
                int newRow=allowedRow[i]+cur.row;
                int newCol=allowedCol[i]+cur.col;
                if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&!visited[newRow][newCol][cur.val^grid[newRow][newCol]]){
                    queue.offer(new Pair(newRow,newCol, cur.val^grid[newRow][newCol]));
                    visited[newRow][newCol][grid[newRow][newCol]^cur.val]=true;
                }
            }
        }
        return min;
    }
}