class Solution {
    public int uniquePaths(int m, int n) {
        // return recursion(m,n,0,0);
        int[][] dp = new int[m][n];
        for(int[] val:dp){
            Arrays.fill(val,-1);
        }
        return memoization(m,n,0,0,dp);
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
}