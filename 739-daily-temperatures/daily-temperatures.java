class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp>stack.peek()[0]){
                int[] t = stack.pop();
                result[t[1]] =i-t[1];
            }
            stack.push(new int[]{temp,i});
        }
        return result;
    }
}