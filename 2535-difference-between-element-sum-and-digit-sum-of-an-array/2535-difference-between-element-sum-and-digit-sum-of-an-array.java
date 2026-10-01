class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            while(nums[i] > 0){
                int digit = nums[i] % 10;
                digitSum += digit;
                nums[i] /= 10;
            }
        }

        int total = Math.abs(sum - digitSum);
        return total;
    }
}