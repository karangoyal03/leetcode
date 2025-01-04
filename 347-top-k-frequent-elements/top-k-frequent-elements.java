class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            queue.add(new int[]{e.getKey(),e.getValue()});
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[] res = new int[k];
        int i=0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            res[i++] = temp[0];
        }
        return res;

    }
}