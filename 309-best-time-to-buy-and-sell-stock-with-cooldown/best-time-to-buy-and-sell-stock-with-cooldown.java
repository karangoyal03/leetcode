class Solution {
    public int maxProfit(int[] prices) {
        // return recursion(prices,0,1);
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] val :dp){
            Arrays.fill(val,-1);

        }

        return memoization(prices,0,1,dp);
    }

    private int recursion(int[] prices , int indx , int canBuy) {
        if(indx >=prices.length){
            return 0;
        }
        int profit =0;
        if(canBuy ==1) {
            profit = Math.max(-prices[indx]  + recursion(prices, indx+1 , 0) , 0 + recursion(prices, indx+1 , 1));
        }else{
            profit = Math.max( prices[indx] + recursion(prices, indx +2 , 1) , 0  + recursion(prices , indx +1 , 0));
        }
        return profit;
    }

    private int memoization(int[]prices , int indx , int canBuy , int[][]dp){
        if(indx >= prices.length){
            return 0;
        }

        if(dp[indx][canBuy]!=-1){
            return dp[indx][canBuy];
        }

        int profit =0;
        if(canBuy ==1){
            profit = Math.max(-prices[indx] + memoization(prices,indx+1,0,dp) , 0 + memoization(prices,indx+1,1,dp));
        }else{
            profit = Math.max(prices[indx] + memoization(prices,indx+2,1,dp), 0 + memoization(prices,indx+1,0,dp));
        }
        dp[indx][canBuy] = profit;
        return dp[indx][canBuy];
    }
}