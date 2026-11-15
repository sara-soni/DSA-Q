class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int e=1;
        int o=0;
        int res=0;
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum%2==0){
                res=(res+o)%mod;
                e++;
            }
            else{
                res=(res+e)%mod;
                o++;
            }
        }
        return res;
    }
}