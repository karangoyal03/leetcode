class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // agar opening h toh insert mtlb push
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(ch =='}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(ch == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }
            // agr closing h toh delete pop from stack
            // ismein agr closing wala h toh array ka peek element uska opposite wala 
            // hona chahiye tabhi woh pop kr skta h

        }
        if(stack.isEmpty()){
                return true;
            }else{
                return false;
            }  
    }
}