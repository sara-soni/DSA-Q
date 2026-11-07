import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

     
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[k];

   
        for (int x = 0; x < k; x++) {

            int max = 0;
            int element = 0;

            for (int key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    element = key;
                }
            }

            result[x] = element;

            
            map.remove(element);
        }

        return result;
    }
}