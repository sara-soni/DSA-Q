import java.util.*;

class Solution {
    public int solve(List<Integer> nums, int size) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {
            sum += nums.get(right);
            while (right - left + 1 > size) {
                sum -= nums.get(left);
                left++;
            }
            if (right >= size - 1 && sum > 0)
                result = Math.min(result, sum);
        }
        return result;
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            result = Math.min(result, solve(nums, i));
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}