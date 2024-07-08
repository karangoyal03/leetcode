class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return recursion(triangle,triangle.size(),0,0);
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        // return memoization(triangle,triangle.size(),0,0,dp);
        return tabulation(triangle,triangle.size(),triangle.size(),dp);
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

   private int tabulation(List<List<Integer>> triangle , int m, int n,  int[][]dp) {
    for(int i=0;i<n;i++){
        dp[m-1][i] = triangle.get(m-1).get(i);
    }

        // since the memoization started from 0 to n-1 then tabulation will start form n-1 to 0
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){

                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diagonal);
            }
        }

        return dp[0][0];

   }


}