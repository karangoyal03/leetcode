class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<hand.length;i++){
            if(map.containsKey(hand[i])){
                 map.put(hand[i], map.get(hand[i])+1);
            }else{
                map.put(hand[i],1);
            }  
        }
       for (int key : map.keySet()) {
            queue.add(key);
        }

       while(!queue.isEmpty()){
        int min = queue.peek();
        for(int i=min;i<min+groupSize;i++){

                if(!map.containsKey(i)){
                    return false;
                }

                map.put(i, map.get(i)-1);
                if(map.get(i) ==0){
                    if(i!=queue.peek()){
                        return false;
                    }
                    queue.poll();
                }
        }

       }
       return true;


    }
}