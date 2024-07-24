class Solution {
   public int[] sortJumbled(int[] mapping, int[] nums) {
    List<Integer> values = new ArrayList<>();
    for (int val : nums) {
        values.add(getCode(val + "", mapping));
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            int result = Integer.compare(a[1], b[1]);
            if (result == 0) {
                result = Integer.compare(a[2], b[2]);
            }
            return result;
        }
    });

    for (int i = 0; i < nums.length; i++) {
        int[] res = new int[3];
        res[0] = nums[i];
        res[1] = values.get(i);
        res[2] = i;
        pq.add(res);
    }

    int[] result = new int[nums.length];
    int index = 0;
    while (!pq.isEmpty()) {
        int[] temp = pq.poll();
        result[index++] = temp[0];
    }
    return result;
}

private int getCode(String n, int[] mapping) {
    String value = "";
    for (int i = 0; i < n.length(); i++) {
        int ch = Integer.parseInt(n.charAt(i) + "");
        value += mapping[ch];
    }
    return Integer.parseInt(value);
}
}