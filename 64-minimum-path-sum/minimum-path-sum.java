class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        // return recursion(grid,m,n);
        int[][] dp = new int[m+2][n+2];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        return memoization(grid,m,n,dp);
    }

    private int recursion(int[][] grid , int row , int col) {

        if(row<0  || col<0){
            return (int)1e9;
        }
        if(row == 0 && col ==0){
            return grid[0][0];
        }
        int left = recursion(grid,row,col-1) + grid[row][col];
        int right = recursion(grid,row-1,col) + grid[row][col];

        return Math.min(left,right);
    }

    private int memoization(int[][]grid, int row , int col , int[][]dp){
        if(row< 0 || col < 0){
            return (int)1e9;
        }

        if(row ==0 && col == 0){
            return grid[0][0];
        }

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int left = memoization(grid,row,col-1,dp) + grid[row][col];
        int right = memoization(grid,row-1,col,dp) + grid[row][col];
        dp[row][col] = Math.min(left,right);
        return dp[row][col];
    }
}