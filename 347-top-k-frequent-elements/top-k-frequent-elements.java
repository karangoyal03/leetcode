class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.offer(new int[]{entry.getValue(),entry.getKey()});
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = queue.poll()[1];
        }
        return result;
    }
}