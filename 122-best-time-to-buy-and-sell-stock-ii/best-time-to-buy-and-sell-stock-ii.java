class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        // return recursion(prices,0,1,n);
        int[][] dp = new int[n+1][2];
        // for(int[]val:dp){
        //     Arrays.fill(val,-1);
        // }
        // return memoization(prices,0,1,n,dp);
        long res = tabulation(prices,n);
        return (int)res;
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

    private long tabulation(int[]Arr , int n){
    //    dp[n][0] = 0;
    // dp[n][1] = 0;

    // for (int i = n - 1; i >= 0; i--) {
    //     for (int j = 0; j <= 1; j++) {
    //         int profit = 0;
    //         if (j == 1) {
    //             // If we are allowed to buy
    //             profit = Math.max(-prices[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
    //         } else {
    //             // If we are allowed to sell
    //             profit = Math.max(prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
    //         }
    //         dp[i][j] = profit;
    //     }
    // }

    // return dp[0][0];
     long[][] dp = new long[n + 1][2];

        // Initialize the entire dp table with -1
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Base condition: If we have no stocks to buy or sell, profit is 0
        dp[n][0] = dp[n][1] = 0;

        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0]; // The maximum profit is stored at dp[0][0]
    }
} 