class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if( nums1.length == 0 || nums2.length == 0 || k ==0){
            return result;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        for(int i =0; i <Math.min(nums1.length,k);i++){
            minHeap.offer(new int[]{nums1[i]+nums2[0],i,0});
        }
        while(k > 0 &&  !minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];
            result.add(Arrays.asList(nums1[i],nums2[j]));
            k--;
            if(j+1 < nums2.length){
                int newSum = nums1[i] + nums2[j+1];
                minHeap.offer(new int[]{newSum, i, j+1});
            }
        }
        return result;

        
    }
}