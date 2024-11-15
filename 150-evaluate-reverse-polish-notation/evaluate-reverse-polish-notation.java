class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(operand1 + operand2);
                }else if(tokens[i].equals("-")){
                     stack.push(operand1 - operand2);
                }else if(tokens[i].equals("*")){
                    stack.push(operand1 * operand2);
                }else if(tokens[i].equals("/")){
                    stack.push(operand1 / operand2);
                }
            }
        }
        if(!stack.empty()){
 return stack.peek();
        }else{
            return -1;
        }
    }
}