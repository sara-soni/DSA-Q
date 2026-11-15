
class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int p1 = 0;
        int p2 = 0;
        int i = 2;

        while (i < n) {

            if (arr1[p1] > arr2[p2]) {
                p1++;
                arr1[p1] = nums[i];
            }
            else {
                p2++;
                arr2[p2] = nums[i];
            }

            i++;
        }

        int[] result = new int[n];
        int k = 0;

        int j = 0;

        while (j <= p1) {
            result[k++] = arr1[j++];
        }

        j = 0;

        while (j <= p2) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}
