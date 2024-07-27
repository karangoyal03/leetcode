class Solution {
    public int minCostClimbingStairs(int[] cost) {
                int n = cost.length;
                int[] dp = new int[n+1];
                Arrays.fill(dp,-1);
        // return Math.min(recursion(cost,n-1),recursion(cost,n-2));
        // return Math.min(memoization(cost,n-1,dp),memoization(cost,n-2,dp));
        // return Math.min(tabulation(cost,n-1),tabulation(cost,n-2));
        return Math.min(spaceOptimization(cost,n-1),spaceOptimization(cost,n-2));
    }

    private int recursion(int[] cost , int n){
        if(n<0){
            return 0;
        }
        int first = recursion(cost, n-1) + cost[n];
           int  second = recursion(cost, n-2) + cost[n];
        

        return Math.min(first,second);
    }

    private int memoization(int[] cost , int n , int[] dp){
        if(n<0){
            return 0;
        }
        if(dp[n] !=-1){
            return dp[n];
        }
        int first = memoization(cost,n-1,dp) + cost[n];
        int second = memoization(cost,n-2,dp) + cost[n];

        dp[n] = Math.min(first,second);
        return dp[n];

    }

    private int tabulation(int[]cost , int n){
        int[] dp = new int[n+1];
         if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2 ; i<=n;i++){
            int first = dp[i-1] + cost[i];
        int second = dp[i-2] + cost[i];

        dp[i] = Math.min(first,second);
        }
        return dp[n];
    }

    private int spaceOptimization(int[]cost , int n){
         if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }
        int prev = cost[1];
        int prev2 = cost[0];
        for(int i=2;i<=n;i++){
            int first = prev + cost[i];
            int second = prev2 + cost[i];
            int curr = Math.min(first,second);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}