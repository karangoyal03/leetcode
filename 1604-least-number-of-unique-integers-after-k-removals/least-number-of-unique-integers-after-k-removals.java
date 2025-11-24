class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(map.values());
        int queueSize = queue.size();
        while(k>0 && !queue.isEmpty()){
            int num = queue.poll();
            if(k>=num){
                k = k -num;
                queueSize--;
            }

        }

        return queueSize;

    }
}