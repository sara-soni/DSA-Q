class Solution {
    public int arraySign(int[] nums) {
        int neg = 0;
        for (int c : nums) {
            if (c == 0) return 0;
            if (c < 0) neg++;
        }
        return neg % 2 == 0 ? 1 : -1;
    }
}