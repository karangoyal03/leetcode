class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return recursion(nums,n-1);
        // return memoization(nums,n-1,dp);
        // return tabulation(nums,n-1,dp);
        return spaceOptimization(nums,n-1);
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

    private int tabulation(int[]nums , int n , int[]dp){
        dp[0] = nums[0];
        for(int i =1;i<=n;i++){
             int pick  = nums[i];
            if(i>1){
                pick += dp[i-2];
            }   
            int notPick = dp[i-1] + 0;
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n];
    }


    private int spaceOptimization(int[]nums , int n) {
        int prev =nums[0];
        int prev2 =0;
        for(int i=1;i<=n;i++){
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }
            int notPick = prev +0;
            int curr = Math.max(pick,notPick);
            prev2 = prev;
            prev =curr;
        }
        return prev;
    }

}