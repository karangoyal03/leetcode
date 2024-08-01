class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int[] val:dp){
            Arrays.fill(val,-1);
        }
        return memoization(triangle,n,0,0,dp);
        // return recursion(triangle, n, 0, 0);
    }

    private int recursion(List<List<Integer>> triangle, int n, int row, int col) {
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }
        if (row == n) {
            return (int) 1e9;
        }
        int bottom = recursion(triangle, n, row + 1, col) + triangle.get(row).get(col);
        int rightDiagonal = recursion(triangle, n, row + 1, col + 1) + triangle.get(row).get(col);
        return Math.min(bottom, rightDiagonal);
    }

    private int memoization(List<List<Integer>> triangle, int n, int row, int col,int[][]dp){
        if(row == n-1){
            return triangle.get(row).get(col);
        }
        if(row == n){
            return (int)1e9;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int bottom = memoization(triangle,n,row+1,col,dp) + triangle.get(row).get(col);
        int rightDiagonal = memoization(triangle,n,row+1,col+1,dp) + triangle.get(row).get(col);
        dp[row][col] = Math.min(bottom, rightDiagonal);
        return dp[row][col];
    }
}