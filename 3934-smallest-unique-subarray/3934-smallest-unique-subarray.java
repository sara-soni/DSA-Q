class Solution {
    long base = 100007;
    long mod = 1000000007;
    private boolean  isPossible(int[] nums, int k){
        int n = nums.length;
        HashMap<Long,Integer> map = new HashMap<>();
        long hash =0;
        long power = 1;
        for(int i=0; i<k;i++){
            hash = (hash*base + nums[i]) % mod;
            if(i < k-1){
                power = (power*base) %mod;
            }

        }
        map.put(hash,1);
        for(int i= k; i < n;i++){
            hash = (hash - nums[i -k]*power % mod+mod) % mod;
            hash = ( hash * base + nums[i]) %mod;
            map.put(hash,map.getOrDefault(hash,0) + 1);

        }
        for(int val: map.values()){
            if(val == 1){
                return true;
            }

        }
        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int left = 1,right = nums.length;
        int ans = nums.length;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(nums,mid)){
                ans = mid;
                right = mid -1;

            }else{
                left = mid + 1;
            }
            
        }
        return ans;

    }
        
    
}