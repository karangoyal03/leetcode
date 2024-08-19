class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<double[]> queue = new PriorityQueue<>((double[] a, double[] b) -> {
        return Double.compare(b[1], a[1]);
    });

    for (int i = 0; i < points.length; i++) {
        int x2 = points[i][0];
        int y2 = points[i][1];
        double distanceSquare = x2 * x2 + y2 * y2;
        queue.offer(new double[]{i, distanceSquare});

        if (queue.size() > k) {
            queue.poll();
        }
    }

    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
        result[i] = points[(int) queue.poll()[0]];
    }
    return result;
    }
}