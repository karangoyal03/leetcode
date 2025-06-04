class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    // calculate the frequenecy of every integer

    Map<Integer,Integer> map = new HashMap<>();
    for(int num : nums){
        map.put(num , map.getOrDefault(num,0)+1);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        minHeap.offer(new int[]{entry.getValue(),entry.getKey()});

        if(minHeap.size()>k){
            minHeap.poll();
        }

    }

    int[] elements = new int[k];
    for(int i =0;i<k;i++)
        {
          elements[i] = minHeap.poll()[1];  
        }

        return elements;

    }
}