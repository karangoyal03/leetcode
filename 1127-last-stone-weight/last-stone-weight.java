class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int val:stones) {
            queue.add(val);
        }

        while(queue.size()>1) {
            int y = queue.poll();
            int x = queue.poll();

            if(x != y){
                y = Math.abs(y-x);
                queue.add(y);
            }
        }

        return queue.peek()!=null?queue.peek():0;
    }
}