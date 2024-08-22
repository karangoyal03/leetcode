class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        // return recursion(prices,0,1,n);
        int[][] dp = new int[n+1][3];
        for(int[]val:dp){
            Arrays.fill(val,-1);
        }
        return memoization(prices,0,1,n,dp);
    }

    private int recursion(int[] prices , int indx , int canBuy , int n) {
        if(indx == n) {
            return 0;
        }
        int profit =0;
        if(canBuy ==1){
            profit = Math.max(-prices[indx] + recursion(prices,indx+1,0,n) , 0  + recursion(prices,indx+1,1,n));
        }else{
            profit = Math.max(prices[indx] + recursion(prices,indx+1,1,n), 0 + recursion(prices,indx+1,0,n));
        }

        return profit;
    }

    private int memoization(int[]prices, int indx , int canBuy , int n , int[][]dp) {
        if(indx ==n) {
            return 0;
        }

        if(dp[indx][canBuy]!=-1){
            return dp[indx][canBuy];
        }

        int profit =0;
        if(canBuy ==1){
            profit = Math.max( -prices[indx] + memoization(prices,indx+1,0,n,dp), 0 + memoization(prices,indx+1,1,n,dp));
        }else{
            profit = Math.max(prices[indx] + memoization(prices,indx+1,1,n,dp), 0  + memoization(prices,indx+1,0,n,dp));
        }
        dp[indx][canBuy] = profit;
        return dp[indx][canBuy];
    }
} 