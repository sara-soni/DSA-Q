class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] orderedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            orderedQueries[i][0] = queries[i];
            orderedQueries[i][1] = i;
        }
        Arrays.sort(orderedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] frequency = new int[n + 1];
        int[] answer = new int[queries.length];

        int active = 0, left = 0, right = 0;

        for (int[] query : orderedQueries) {
            int q = query[0];
            int originalIndex = query[1];
            int lower = q - x;

            while (right < logs.length && logs[right][1] <= q) {
                int server = logs[right][0];
                if (frequency[server] == 0) {
                    active++;
                }
                frequency[server]++;
                right++;
            }

            while (left < right && logs[left][1] < lower) {
                int server = logs[left][0];
                frequency[server]--;
                if (frequency[server] == 0) {
                    active--;
                }
                left++;
            }

            answer[originalIndex] = n - active;
        }

        return answer;
    }
}