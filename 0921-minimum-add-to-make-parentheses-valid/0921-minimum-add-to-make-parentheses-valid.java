class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        int ans=0;
        for(int i=0;i<n;i++){
            Character ch=s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
                if(open >0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        return open+close;
    }
}