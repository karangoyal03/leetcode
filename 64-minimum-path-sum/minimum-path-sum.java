class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        // return recusrion(grid,grid.length-1,grid[0].length-1);
        return memoization(grid,grid.length-1,grid[0].length-1,dp);
    }

    private int recusrion(int[][] grid , int row , int col) {
        if(row == 0 && col ==0) {
            return grid[0][0];
        }

        if(row<0  || col<0) {
            return (int)Math.pow(10, 9);
        }

        int up =  grid[row][col]+ recusrion(grid,row-1,col);
        int left =  grid[row][col] + recusrion(grid,row,col-1);
        return Math.min(up,left);
    }

    private int memoization(int[][] grid , int row  , int col , int[][]dp) {
        if(row == 0 && col == 0) {
            return grid[0][0];
        }

        if(row<0 || col<0) {
            return (int)Math.pow(10,9);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int up = grid[row][col] + memoization(grid,row-1,col,dp);
        int down = grid[row][col] + memoization(grid,row,col-1,dp);
        dp[row][col]  = Math.min(up,down);
        return dp[row][col];
    }
}