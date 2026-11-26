class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for(int i=0; i <n;i++){
            for(int j =0; j < n;j++){
                maxheap.add(matrix[i][j]);
                if(maxheap.size()>k){
                    maxheap.poll();
                }
            }
        }
        return maxheap.peek();




        
    }
}