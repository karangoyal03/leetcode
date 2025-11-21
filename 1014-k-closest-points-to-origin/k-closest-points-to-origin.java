class Solution {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[2] - b[2]);
    public int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][2];

        for(int[] point : points){
            int distance = (int)(Math.pow(point[0],2) + Math.pow(point[1],2));
            queue.add(new int[]{point[0],point[1],distance});
        }

        for(int i=0;i<k;i++){
            int[] point = queue.poll();
            result[i] = new int[]{point[0],point[1]};
        }

        return result;

    }
}