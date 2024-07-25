class MinStack {
        Stack<Integer>  main = new Stack<>();
        Stack<Integer> helper = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        main.push(val);
        if(helper.isEmpty()){
            helper.push(val);
        }else{
            helper.push(Math.min(val,helper.peek()));
        }
    }
    
    public void pop() {
        main.pop();
        helper.pop();
            }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */