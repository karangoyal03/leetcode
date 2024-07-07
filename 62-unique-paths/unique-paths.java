class Solution {
    public int uniquePaths(int m, int n) {
        // return recursion(m,n,0,0);
        int[][] dp = new int[m][n];
        for(int[] val:dp){
            Arrays.fill(val,-1);
        }
        // return memoization(m,n,0,0,dp);
        return tabulation(m,n,dp);
    }

    private static int recursion(int m, int n, int row , int col) {
    if(row == m-1 && col == n-1) {
      return 1;
    }

    if(row == m || col == n){
      return 0;
    }
    int count =0;
    count+=recursion(m,n,row,col+1);
    count+=recursion(m,n,row+1,col);
      return count;
  }

  private static int memoization(int m, int n , int row , int col , int [][]dp) {
    if(row == m-1 && col == n-1){
        return 1;
    }

    if(row == m || col == n) {
        return 0;
    }
    if(dp[row][col]!=-1) {
        return dp[row][col];
    }
    int count =0;
    count+=memoization(m,n,row,col+1,dp);
    count+=memoization(m,n,row+1,col,dp);
    dp[row][col]=count;
    return dp[row][col];
  }

  private static int tabulation(int m , int n , int[][] dp) {
   dp[0][0] =1;
   for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
        if(i ==0 && j==0){
            continue;
        }

        int up=0;
        int left=0;
        if(i>0){
            up=dp[i-1][j];
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