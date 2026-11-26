class Solution {
    public int calculate(String s) {
        int res = 0,n=0;
        Stack<Integer> st = new Stack<>();
        s += '+';
        char op = '+';
        for(int i=0; i < s.length();i++){
            char c = s.charAt(i);
            if ( c == ' ') continue;
            if(Character.isDigit(c)){
                n = n* 10+(c - '0');
                continue;
            }
            if( op == '+')st.push(n);
            else if(op == '-')st.push(-n);
            else if(op == '*')st.push(st.pop() * n);
            else if(op == '/') st.push(st.pop()/n);
            op = c;
            n=0;
        }
        for(int i : st){
            res += i;
        }
        return res;
        
    }
}