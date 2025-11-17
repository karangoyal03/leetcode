class Solution {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
    public int lastStoneWeight(int[] stones) {
        for(int i=0;i<stones.length;i++){
            queue.add(stones[i]);
        }

        while(queue.size()>1){
            int y = queue.poll();
            int x = queue.poll();
                if( x!=y){
                    y = y -x;
                    queue.add(y);
                }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}