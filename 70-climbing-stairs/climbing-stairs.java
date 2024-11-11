class Solution {
    public int climbStairs(int n) {
    //    return recursion(n);
    int[] dp = new int[n+1];
    Arrays.fill(dp,-1);
    return memoization(n,dp);
    }

    private int recursion(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return recursion(n-1)+ recursion(n-2);

    }
    private int memoization(int n , int[]dp){
        if(n==0){
            return 1;
        }

        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = memoization(n-1,dp) + memoization(n-2,dp);
        return dp[n];
    }
}