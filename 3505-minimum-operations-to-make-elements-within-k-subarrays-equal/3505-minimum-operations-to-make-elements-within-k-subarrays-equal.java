import java.util.*;

class Solution {
    int m, top, need, x;
    long[] cnt, sm;
    long[] vals;

    private void update(int i, int c, long v) {
        for (; i <= m; i += i & -i) {
            cnt[i] += c;
            sm[i] += v;
        }
    }

    private long windowCost(long total) {
        int pos = 0;
        long c = 0, s = 0;

        for (int step = top; step > 0; step >>= 1) {
            int nxt = pos + step;

            if (nxt <= m && c + cnt[nxt] < need) {
                pos = nxt;
                c += cnt[nxt];
                s += sm[nxt];
            }
        }

        long med = vals[pos];

        return (med * c - s) + ((total - s) - med * (x - c));
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        this.x = x;

        // Coordinate compression
        long[] sorted = new long[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted);

        int u = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[u++] = sorted[i];
            }
        }

        vals = Arrays.copyOf(sorted, u);
        m = u;

        cnt = new long[m + 1];
        sm = new long[m + 1];

        top = 1;

        while (top * 2 <= m) {
            top *= 2;
        }

        need = (x + 1) / 2;

        // Calculate cost of every window
        final long INF = Long.MAX_VALUE / 4;

        long[] cost = new long[n];
        Arrays.fill(cost, INF);

        long total = 0;

        for (int i = 0; i < n; i++) {
            int id = Arrays.binarySearch(vals, nums[i]) + 1;

            update(id, 1, nums[i]);
            total += nums[i];

            if (i >= x) {
                int old = Arrays.binarySearch(vals, nums[i - x]) + 1;

                update(old, -1, -nums[i - x]);
                total -= nums[i - x];
            }

            if (i >= x - 1) {
                cost[i] = windowCost(total);
            }
        }

        // Dynamic Programming
        long[] prev = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);

            for (int i = 1; i <= n; i++) {
                cur[i] = cur[i - 1];

                if (i >= x && prev[i - x] < INF) {
                    cur[i] = Math.min(
                        cur[i],
                        prev[i - x] + cost[i - 1]
                    );
                }
            }

            prev = cur;
        }

        return prev[n];
    }
}