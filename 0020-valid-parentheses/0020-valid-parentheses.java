class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0; i <ch.length;i++){
            if(ch[i]=='('|| ch[i]=='['||ch[i]=='{'){
                s1.push(ch[i]);
            }
            if(ch[i]==')'){
                if(s1.empty() || s1.peek() != '('){
                    return false;
                }
                s1.pop();

            }
            if(ch[i] ==']'){
                if(s1.empty() || s1.peek() != '['){
                    return false;
                }
                s1.pop();
            }
        if(ch[i] == '}'){
            if(s1.empty() || s1.peek() != '{'){
                return false;
            }
            s1.pop();
        }
        }
        return s1.empty();
        
    }
}