class Solution {
    long mod = 1000000007;

    long[][] mul(long[][] x, long[][] y) {
        long[][] res = {
            {(x[0][0] * y[0][0] + x[0][1] * y[1][0]) % mod, (x[0][0] * y[0][1] + x[0][1] * y[1][1]) % mod},
            {(x[1][0] * y[0][0] + x[1][1] * y[1][0]) % mod, (x[1][0] * y[0][1] + x[1][1] * y[1][1]) % mod}
        };
        return res;
    }

    public int countGoodStrings(long n) {
        long[][] mat = {{1, 0}, {0, 1}};
        long[][] b = {{1, 1}, {1, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                mat = mul(mat, b);
            }
            b = mul(b, b);
            n >>= 1;
        }
        int res = (int) (mat[0][1] * 2 % mod);
        return res;
    }
}