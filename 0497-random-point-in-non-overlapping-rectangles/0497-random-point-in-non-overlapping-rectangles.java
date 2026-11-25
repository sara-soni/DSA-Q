class Solution {
    private int[][] rects;
    private int[] prefix;
    private Random rand = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new int[rects.length];
        int sum = 0;
        
        for (int i = 0; i < rects.length; i++) {
            sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            prefix[i] = sum;
        }
    }
    
    public int[] pick() {
        int target = rand.nextInt(prefix[prefix.length - 1]) + 1;
        
        // Binary search for prefix sum >= target
        int idx = Arrays.binarySearch(prefix, target);
        if (idx < 0) idx = -idx - 1;
        
        int[] r = rects[idx];
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        
        return new int[]{x, y};
    }
}