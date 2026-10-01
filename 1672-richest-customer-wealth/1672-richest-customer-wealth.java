class Solution {
    public int maximumWealth(int[][] accounts) {
        int rich = 0;
        for (int[] i : accounts) {
            int sum = 0;
            for (int money : i) {
                sum += money;
            }
            rich = Math.max(rich, sum);
        }
        return rich;
    }
}  