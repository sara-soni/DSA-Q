class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left =0;
        int right=nums.length -1;
        long totalMoves =0;
        while(left<right){
            totalMoves += (long) nums[right] - nums[left];
            left++;
            right--;
        }
        return (int) totalMoves;
        
    }
}