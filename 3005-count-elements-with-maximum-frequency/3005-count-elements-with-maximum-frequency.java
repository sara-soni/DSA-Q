import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {

        ArrayList<Integer> li = new ArrayList<>();

        for (int num : nums) {
            li.add(num);
        }

        int max = 0;
        int total = 0;

        for (int i = 0; i < li.size(); i++) {

            int num = li.get(i);

            if (li.subList(0, i).contains(num)) {
                continue;
            }

            int count = Collections.frequency(li, num);

            if (count > max) {
                max = count;
                total = count;
            }
            else if (count == max) {
                total += count;
            }
        }

        return total;
    }
}