class Solution {
    public int maxProfit(int[] prices) {
    // return recursion(prices, 0, 1, 2);
    int n =prices.length;
    int[][][] dp = new int[n+1][2][3];
   for(int[][] grid : dp){
    for(int[] val : grid){
        Arrays.fill(val,-1);
    }
   }
    // return memoization(prices,0,1,2,dp);
    return tabulation(prices,n,dp);
}

private int recursion(int[] prices, int indx, int canBuy, int cap) {
    if (cap == 0 || indx == prices.length) {
        return 0;
    }

    int profit = 0;
    if (canBuy == 1) {
        profit = Math.max(-prices[indx] + recursion(prices, indx + 1, 0, cap), 
                           recursion(prices, indx + 1, 1, cap));
    } else {
        profit = Math.max(prices[indx] + recursion(prices, indx + 1, 1, cap - 1), 
                          recursion(prices, indx + 1, 0, cap));
    }
    return profit;
}

private int memoization(int[] prices, int indx, int canBuy, int cap, int[][][] dp) {
    if (cap == 0 || indx == prices.length) {
        return 0;
    }

    if (dp[indx][canBuy][cap] != -1) {
        return dp[indx][canBuy][cap];
    }

    int profit = 0;
    if (canBuy == 1) {
        profit = Math.max(-prices[indx] + memoization(prices, indx + 1, 0, cap, dp),
                          memoization(prices, indx + 1, 1, cap, dp));
    } else {
        profit = Math.max(prices[indx] + memoization(prices, indx + 1, 1, cap - 1, dp),
                          memoization(prices, indx + 1, 0, cap, dp));
    }

    dp[indx][canBuy][cap] = profit;
    return dp[indx][canBuy][cap];
}

private int tabulation(int[]prices , int n ,int[][][]dp){
 for (int indx = 0; indx < n; indx++) {
        for (int buy = 0; buy <= 1; buy++) {
            dp[indx][buy][0] = 0; // No transactions left
        }
    }

    for (int buy = 0; buy <= 1; buy++) {
        for (int cap = 0; cap <= 2; cap++) {
            dp[n][buy][cap] = 0; // No days left to trade
        }
    }

    for(int i = n-1 ; i>=0;i--){
        for(int b =0 ; b<=1;b++){
            for(int c = 1 ;c<=2;c++){
                int profit =0;
               if(b ==1){
                profit = Math.max( - prices[i] + dp[i+1][0][c] , 0 + dp[i+1][1][c]);
               }else{
                profit = Math.max( prices[i] + dp[i+1][1][c-1] , 0 + dp[i+1][0][c]);
               }     
                dp[i][b][c] = profit;
            }
        }
    }
    return dp[0][1][2];
}

}