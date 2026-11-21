
import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        // Store position and speed together
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            double time = (double)(target - cars[i][0])
                          / cars[i][1];

            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        }

        return st.size();
    }
}
