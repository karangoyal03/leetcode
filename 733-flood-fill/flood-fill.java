class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        // dfs(image,sr,sc,dx,dy,color,ans,initialColor);
        bfs(image,sr,sc,dx,dy,color,ans,initialColor);
        return ans;

    }

    public void dfs(int[][]image , int sr , int sc , int[] dx ,int[] dy , int newColor , int[][] ans , int oldColor){

        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;

        for( int i =0;i<4;i++){

            int nx = sr + dx[i];
            int ny = sc + dy[i];

            if(nx>=0 && ny >= 0  && nx<n && ny<m && image[nx][ny] == oldColor && ans[nx][ny] != newColor){
                dfs(image,nx,ny,dx,dy,newColor,ans,oldColor);
            }  
        }
    }

    public void bfs(int[][]image , int sr , int sc , int[] dx , int[] dy , int newColor , int[][] ans , int initialColor){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;
        while(!queue.isEmpty()){
            int size = queue.size();
            for( int i=0;i<size;i++){
                int[] point = queue.poll();
                for(int j =0;j<4 ;j++){
                    int nx = point[0] + dx[j];
                    int ny = point[1]  + dy[j];

                    if(nx >=0 && ny>=0 && nx<n && ny<m && image[nx][ny] == initialColor && ans[nx][ny] != newColor ) {
                        queue.offer(new int[]{nx,ny});
                        ans[nx][ny] = newColor;
                    }
                }
            }
        }

    }
}