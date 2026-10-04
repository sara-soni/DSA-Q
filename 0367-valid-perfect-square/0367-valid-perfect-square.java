class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        while (low<=high) {
            long mid = low + (high - low)/2;
            long sq = mid * mid;
            if (sq == num) return true;
            if (sq < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}