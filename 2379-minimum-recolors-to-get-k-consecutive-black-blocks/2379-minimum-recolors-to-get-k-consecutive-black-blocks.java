
class Solution {
    public int minimumRecolors(String blocks, int k) {

        int left = 0;
        int right = 0;

        int white = 0;
        int min = Integer.MAX_VALUE;

        while (right < blocks.length()) {

            if (blocks.charAt(right) == 'W') {
                white++;
            }

            if (right - left + 1 == k) {

                min = Math.min(min, white);

                if (blocks.charAt(left) == 'W') {
                    white--;
                }

                left++;
            }

            right++;
        }

        return min;
    }
}
