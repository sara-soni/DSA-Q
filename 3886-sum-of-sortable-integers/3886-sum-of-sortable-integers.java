class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] s = nums.clone();
        java.util.Arrays.sort(s);
        int ans = 0;
        
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            boolean valid = true;
            for (int start = 0; start < n; start += k) {
                if (!checkRotation(nums, s, start, k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans += k;
            }
        }
        return ans;
    }
    
    private boolean checkRotation(int[] nums, int[] s, int start, int k) {
        if (k == 1) {
            return nums[start] == s[start];
        }
        
        int[] lps = new int[k];
        int len = 0;
        int i = 1;
        
        while (i < k) {
            if (s[start + i] == s[start + len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        i = 0;
        int j = 0;
        
        while (i < k * 2) {
            if (s[start + j] == nums[start + (i % k)]) {
                j++;
                i++;
            }
            if (j == k) {
                return true;
            } else if (i < k * 2 && s[start + j] != nums[start + (i % k)]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return false;
    }
}