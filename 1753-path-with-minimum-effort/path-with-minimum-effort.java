class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>((x,y)-> x.diff - y.diff);
        int n = heights.length;
        int m = heights[0].length;
        int[][] distance = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j] = (int)1e9;
            }
        }
        distance[0][0] =0;
        queue.add(new Tuple(0,0,0));
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!queue.isEmpty()){
            Tuple tp = queue.remove();
            int dis = tp.diff;
            int row = tp.row;
            int col = tp.col;
            if(row == n-1 && col == m-1){
                return dis;
            }

            for(int i=0;i<4;i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if(nrow<n && ncol<m && nrow>=0 && ncol>=0){
                    int newDistance = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]),dis);
                    if(newDistance< distance[nrow][ncol]){
                        distance[nrow][ncol] = newDistance;
                        queue.add(new Tuple(newDistance,nrow,ncol));
                    }
                }
            }
            
        }
        return 0;
    }
}

class Tuple {
    int diff;
    int row;
    int col;
    public Tuple(int diff ,int row , int col){
        this.diff=diff;
        this.row =row;
        this.col = col;
    }
}