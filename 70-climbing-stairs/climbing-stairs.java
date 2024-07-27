class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return recursion(n);
        return memoization(n,dp);
    }

    private int recursion(int n){
       if(n ==0){
        return 1;
       }
       if(n<0){
        return 0;
       }

       int step1 = recursion(n-1);
       int step2 = recursion(n-2);
       return step1 + step2;
    }

    private int memoization(int n , int[] dp){
        if(n ==0){
            return 1;
        }

        if(n<0){
            return 0;
        }

        if(dp[n] !=-1){
            return dp[n];
        }

        int step1 = memoization(n-1,dp);
        int step2 = memoization(n-2,dp);
        dp[n] = step1 + step2;
        return dp[n];
    }
}