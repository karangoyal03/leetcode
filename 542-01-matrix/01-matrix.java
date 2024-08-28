class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                } else if (mat[i][j] == 1) {
 visited[i][j] = false;
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while(!queue.isEmpty()){
            int[] val = queue.poll();
            int row = val[0];
            int col = val[1];
            int steps = val[2];
            distance[row][col] = steps;
            for(int i=0;i<4;i++){
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny] ==false){
                    queue.add( new int[] {nx,ny,steps+1});
 visited[nx][ny] = true;
                }
            }
        }
        return distance;
    }

// public int[][] updateMatrix(int[][] mat) {
//     int n = mat.length;
//     int m = mat[0].length;
//     boolean[][] visited = new boolean[n][m];
//     int[][] distance = new int[n][m];
//     Queue<int[]> queue = new LinkedList<>();
    
//     // Initialize the queue with all 0 positions and mark them as visited
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//             if (mat[i][j] == 1) {
//                 queue.add(new int[] { i, j, 0 });
//                 visited[i][j] = true;
//             }
//         }
//     }

//     int[] dx = { -1, 0, 1, 0 };
//     int[] dy = { 0, 1, 0, -1 };
    
//     while (!queue.isEmpty()) {
//         int[] val = queue.poll();
//         int row = val[0];
//         int col = val[1];
//         int steps = val[2];
//         distance[row][col] = steps;
        
//         for (int i = 0; i < 4; i++) {
//             int nx = row + dx[i];
//             int ny = col + dy[i];

//             if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
//                 visited[nx][ny] = true; // Mark as visited before adding to the queue
//                 queue.add(new int[] { nx, ny, steps + 1 });
//             }
//         }
//     }
    
//     return distance;
// }

}