class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return recursion(n);
        // return memoization(n,dp);
        // return tabulation(n);
        return spaceOptimization(n);
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

    private int tabulation(int n){
        int[] dp = new int[n+1];
        dp[0] =1;

        for(int i=1;i<=n;i++){
            int first = dp[i-1];
            int second = 0;
            if(i>1){
            second = dp[i-2];
            }
            dp[i] = first + second;
        }
        return dp[n];
    }

    private int spaceOptimization(int n){
        int prev =1;
        int prev2 =0;

        for(int i=1;i<=n;i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}