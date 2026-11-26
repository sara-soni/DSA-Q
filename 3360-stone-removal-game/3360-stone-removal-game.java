class Solution {
    public boolean canAliceWin(int n) {
        
       int k = 10, t=0;
       while( n >= k){
         n -= k;
         k--;
         t++;
       }
       return t % 2 == 1;
}
}