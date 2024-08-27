class Solution {
public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
    }

    int n = grid.length;
    int m = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int countFresh = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 2) {
                queue.offer(new int[]{i, j});
            } else if (grid[i][j] == 1) { // Use 1 to count fresh oranges
                countFresh++;
            }
        }
    }

    if (countFresh == 0) return 0;

    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    int countMin = 0;
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean rotted = false;

        for (int i = 0; i < size; i++) {
            int[] point = queue.poll();

            for (int j = 0; j < 4; j++) {
                int row = point[0] + dx[j];
                int col = point[1] + dy[j];

                if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] != 1) {
                    continue;
                }

                grid[row][col] = 2;
                queue.offer(new int[]{row, col});
                countFresh--;
                rotted = true;
            }
        }

        if (rotted) {
            countMin++;
        }
    }

    return countFresh == 0 ? countMin : -1;
}
}