class Solution {
    public int secondHighest(String s) {
        int lar=-1;
        int seclar=-1;
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num= ch-'0';
                if(num>lar){
                    seclar=lar;
                    lar=num;
                }
                else if(num>=seclar && num != lar){
                    seclar=num;
                   
                }
    
            }
           
        }
         return seclar;
           
    }
}
    