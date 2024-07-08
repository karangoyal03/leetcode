class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return recursion(triangle,triangle.size(),0,0);
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        return memoization(triangle,triangle.size(),0,0,dp);
    }

    private int recursion(List<List<Integer>> triangle , int indx , int row , int col){
        if(indx-1  == row) {
            return triangle.get(row).get(col);
        }
        if(row == indx) {
            return (int)Math.pow(10,9);
        }
        int down = triangle.get(row).get(col) +recursion(triangle,indx,row+1,col);
        int diagonal = triangle.get(row).get(col) + recursion(triangle,indx,row+1,col+1);
        return Math.min(down,diagonal);
   }

   private int memoization(List<List<Integer>> triangle , int indx , int row , int col, int[][]dp){
        if(indx -1 == row) {
            return triangle.get(row).get(col);
        }
        if(row == indx) {
            return (int)Math.pow(10,9);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down = triangle.get(row).get(col) + memoization(triangle,indx,row+1,col,dp);
        int diagonal = triangle.get(row).get(col) + memoization(triangle,indx,row+1,col+1,dp);
        dp[row][col] = Math.min(down,diagonal);
        return dp[row][col];

   }


}