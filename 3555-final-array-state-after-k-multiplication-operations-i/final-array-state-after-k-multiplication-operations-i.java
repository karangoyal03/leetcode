class Solution {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        queue.clear();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] output = queue.poll();
            int num = output[0];
            int index = output[1];

            num = num * multiplier;
            queue.add(new int[]{num, index});
        }

        int[] result = new int[nums.length];
        while (!queue.isEmpty()) {
            int[] output = queue.poll();
            int num = output[0];
            int index = output[1];
            result[index] = num;
        }
        return result;

    }
}