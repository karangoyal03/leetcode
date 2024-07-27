class Solution {
    public int minCostClimbingStairs(int[] cost) {
                int n = cost.length;
                int[] dp = new int[n+1];
                Arrays.fill(dp,-1);
        // return Math.min(recursion(cost,n-1),recursion(cost,n-2));
        return Math.min(memoization(cost,n-1,dp),memoization(cost,n-2,dp));
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
}