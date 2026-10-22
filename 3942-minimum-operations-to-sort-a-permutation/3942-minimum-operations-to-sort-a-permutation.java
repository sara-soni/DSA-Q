class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos = i;
                break;
            }
        }

        boolean normal = true;
        boolean reversed = true;

        for (int i = 0; i < n; i++) {
            if (nums[(pos + i) % n] != i) {
                normal = false;
            }

            if (nums[(pos - i + n) % n] != i) {
                reversed = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (normal) {
            ans = Math.min(ans, Math.min(pos, n - pos + 2));
        }

        if (reversed) {
            int rpos = n - 1 - pos;
            ans = Math.min(ans, 1 + Math.min(rpos, n - rpos));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}