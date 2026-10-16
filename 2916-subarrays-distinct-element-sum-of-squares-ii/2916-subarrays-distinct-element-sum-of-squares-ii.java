class Solution {
    private long[] bit1;
    private long[] bit2;
    private int n;

    private long prefixSum(int k) {
        long s1 = 0, s2 = 0;
        int index = k;

        while (index > 0) {
            s1 += bit1[index];
            s2 += bit2[index];
            index -= index & -index;
        }

        return (long)k * s1 - s2;
    }

    private void addBoundary(int index, long delta) {
        long weighted = delta * (index - 1);

        while (index <= n) {
            bit1[index] += delta;
            bit2[index] += weighted;
            index += index & -index;
        }
    }

    public int sumCounts(int[] nums) {
        final long MOD = 1000000007L;

        n = nums.length;
        bit1 = new long[n + 1];
        bit2 = new long[n + 1];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long totalDistinct = 0;
        long endingSquares = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int p = last[value];

            long affectedSum =
                totalDistinct - prefixSum(p + 1);

            long length = i - p;

            endingSquares =
                (endingSquares + 2 * affectedSum + length) % MOD;

            answer = (answer + endingSquares) % MOD;

            addBoundary(p + 2, 1);
            addBoundary(i + 2, -1);

            totalDistinct += length;
            last[value] = i;
        }

        return (int)answer;
    }
}