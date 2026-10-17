class Solution {
   
    public int getSum(int num)
    {
        int sum=0;
        while(num!=0)
        {
            sum+= num%10;
            num/= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n= nums.length;
        int arr[][]= new int[n][3];

       
        for(int i=0; i<n; i++)
        {
            int sumOfDigits= getSum(nums[i]);

            arr[i][0]= nums[i];
            arr[i][1]= sumOfDigits;
            arr[i][2]= i;
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[1]==b[1])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });

       
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            
            if (visited[i] || arr[i][2] == i)
                continue;

            int cycleLength = 0;
            int j = i;

            
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleLength++;
            }

            swaps += cycleLength - 1;
        }

        return swaps;
    }
}