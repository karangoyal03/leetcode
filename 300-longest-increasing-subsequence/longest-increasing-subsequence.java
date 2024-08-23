class Solution {
    public int lengthOfLIS(int[] nums) {
    //    return recursion(nums,0,-1); 
    int[][] dp = new int[nums.length+1][nums.length+1];
    for(int[] val : dp){
        Arrays.fill(val,-1);
    }
    // return memoization(nums,0,-1,dp);
    return tabulation(nums,nums.length,dp);
    }

    private int recursion(int[]nums , int indx , int prev) {
        if(indx == nums.length){
            return 0;
        }

        int notTake = 0  + recursion(nums,indx+1,prev);
        int take = 0;
        if(prev == -1  || nums[indx] > nums[prev]){
            take = 1 + recursion(nums,indx+1,indx);
        }

        return Math.max(notTake,take);
    }

    private int memoization(int[]nums , int indx , int prev , int[][]dp) {
        if(indx == nums.length){
            return 0;
        }

        if(dp[indx][prev+1] !=-1){
            return dp[indx][prev+1];
        }

        int notTake = 0  + memoization(nums,indx+1,prev,dp);
        int take =0;
        if(prev == -1  || nums[indx]> nums[prev]){
            take = 1 +  memoization(nums,indx+1,indx,dp);
        }

        dp[indx][prev+1] = Math.max(notTake , take);
        return dp[indx][prev+1];
    }


private int tabulation(int[] nums, int n ,int[][] dp) {
    for (int i = 0; i <= n; i++) {
        dp[n][i] = 0;
    }

    for (int i = n - 1; i >= 0; i--) {
        for (int j = i - 1; j >= -1; j--) {  

            int notTake = dp[i + 1][j + 1];
            int take = 0;
            if (j == -1 || nums[i] > nums[j]) {
                take = 1 + dp[i + 1][i + 1];
            }

            dp[i][j + 1] = Math.max(notTake, take);
        }
    }

    return dp[0][0]; // The result is stored in dp[0][0]
}

}