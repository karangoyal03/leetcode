class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);  
            if(queue.size()>k){
                // System.out.println(queue.peek());
                queue.poll();
            }
                   
        }
        
        return queue.peek();
    }
}