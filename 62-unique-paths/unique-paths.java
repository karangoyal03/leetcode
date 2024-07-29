class Solution {
    public int uniquePaths(int m, int n) {
        // return recursion(m-1,n-1);
        int[][] dp = new int[m+1][n+1];
        for(int[] val : dp) {
            Arrays.fill(val,-1);
        }
        return memoization(m-1,n-1,dp);
    }

    private int recursion(int row , int col) {

        if(row ==0 && col ==0) {
            return 1;
        }

        if(row< 0 || col<0) {
            return 0;
        }

        int left = recursion(row,col-1);
        int top = recursion(row-1,col);

        return left +top;

    }

    private int memoization(int row , int col , int[][] dp) {
        if(row ==0 && col ==0) {
            return 1;
        }

        if(row < 0  || col <0){
            return 0;
        }

        if(dp[row][col]!=-1) {
            return dp[row][col];
        }

        int left = memoization(row,col-1,dp);
        int top = memoization(row-1,col,dp);

        dp[row][col] = left + top;
        return dp[row][col];
    }
}