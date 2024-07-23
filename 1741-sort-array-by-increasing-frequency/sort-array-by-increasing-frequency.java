class Solution {
public int[] frequencySort(int[] nums) {
    HashMap<Integer, Integer> freMap = getAllFrequency(nums);
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            int result = Integer.compare(a[1], b[1]);
            if (result == 0) {
                result = Integer.compare(b[0], a[0]);
            }
            return result;
        }
    });

    freMap.forEach((key, value) -> {
        int[] res = new int[2];
        res[0] = key;
        res[1] = value;
        pq.add(res);
    });

    List<Integer> ans = new ArrayList<>();
    while (!pq.isEmpty()) {
        int[] temp = pq.poll();
        int key = temp[0];
        int fre = temp[1];
        for (int i = 0; i < fre; i++) {
            ans.add(key);
        }
    }

    return ans.stream().mapToInt(i -> i).toArray();
}

private HashMap<Integer, Integer> getAllFrequency(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return map;
}

}