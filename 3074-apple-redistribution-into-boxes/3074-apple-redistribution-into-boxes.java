class Solution {
    public int minimumBoxes(int[] a, int[] c) {
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        Arrays.sort(c);
        int sum1=0;
        int v=0;
        for(int i=c.length-1;i>=0;i--){
            sum1+=c[i];
            v++;
            if(sum1>=sum){
                return v;
            }
        }
        return 0;
    }
}