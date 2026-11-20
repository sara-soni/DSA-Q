class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int d0 = 1, d1 = 1, ans = 1;

        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];

            switch (diff) {
                case 0:
                    d1 = d0 + 1;
                    break;
                case 1:
                    d0++;
                    d1++;
                    break;
                case 2:
                    d0 = d1 + 1;
                    d1 = 1;
                    break;
                default:
                    d0 = d1 = 1;
            }

            ans = Math.max(ans, Math.max(d0, d1));
        }

        return ans;
    }
}