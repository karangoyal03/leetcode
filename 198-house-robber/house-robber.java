class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return recursion(nums,n-1);
        return memoization(nums,n-1,dp);
    }

    private int recursion(int[] nums , int n){
        if(n<0){
            return 0;
        }

        int pick = recursion(nums,n-2) + nums[n];

        int notPick = recursion(nums,n-1) + 0;

        return Math.max(pick,notPick);

    }

    private int memoization(int[]nums , int n, int[] dp) {
        if(n<0) {
            return 0;
        }
        if(dp[n] !=-1){
            return dp[n];
        }
        int pick = memoization(nums,n-2,dp) + nums[n];

        int notPick = memoization(nums,n-1,dp) + 0;

        dp[n] = Math.max(pick,notPick);
        return dp[n];
    }

}