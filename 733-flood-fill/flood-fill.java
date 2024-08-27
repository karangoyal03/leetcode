class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        dfs(image,sr,sc,dx,dy,color,ans,initialColor);
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
}