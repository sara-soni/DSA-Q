
import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        
        for (int i = 0; i < nums1.length; i++) {
            int id = nums1[i][0];
            int val = nums1[i][1];

            map.put(id, map.getOrDefault(id, 0) + val);
        }

        
        for (int i = 0; i < nums2.length; i++) {
            int id = nums2[i][0];
            int val = nums2[i][1];

            map.put(id, map.getOrDefault(id, 0) + val);
        }

        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

    
        int[][] ans = new int[keys.size()][2];

        for (int i = 0; i < keys.size(); i++) {
            int id = keys.get(i);

            ans[i][0] = id;
            ans[i][1] = map.get(id);
        }

        return ans;
    }
}
