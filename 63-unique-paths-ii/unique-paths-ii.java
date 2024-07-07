class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] val :dp){
            Arrays.fill(val,-1);
        }
        // return recursion(m-1,n-1,obstacleGrid);
        // return memoization(m-1,n-1,obstacleGrid,dp);
        return tabulation(m,n,obstacleGrid,dp);
    }
    private int recursion(int row , int col  ,int[][]board) {
    if(row<0 || col <0) {
      return 0;
    }
    if(row == 0 && col ==0 && board[row][col] != 1) {
      return 1;
    }
    if(board[row][col] == 1) {
      return 0;
    }
        int up = recursion(row-1,col,board);
        int left = recursion(row,col-1,board);

    return up+left;
  }

  private int memoization(int row , int col , int[][] board,int[][]dp){
    if(row<0 || col<0){
        return 0;
    }
    if(row ==0 && col ==0 && board[row][col]!=1){
        return 1;
    }

    if(board[row][col]==1){
        return 0;
    }

    if(dp[row][col]!=-1){
        return dp[row][col];
    }
    int up = memoization(row-1,col,board,dp);
    int left = memoization(row,col-1,board,dp);
    dp[row][col] = up+left;
    return dp[row][col];
  }

  private int tabulation(int m , int n , int[][]board , int[][]dp){
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]==1){
                dp[i][j]=0;
                continue;
            }
             if(i ==0 && j == 0){
                dp[0][0]=1;
                continue;
            }
            
                    int up =0; 
                    int left =0; 

                    if(i>0){
                        up = dp[i-1][j];
                    }

                    if(j>0){
                        left = dp[i][j-1]; 
                    }

                    dp[i][j] = up+left;
                
            
        }
    }
    return dp[m-1][n-1];
  }
}