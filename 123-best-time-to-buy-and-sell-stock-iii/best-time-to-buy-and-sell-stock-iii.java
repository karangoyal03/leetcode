class Solution {
    public int maxProfit(int[] prices) {
    // return recursion(prices, 0, 1, 2);
    int n =prices.length;
    int[][][] dp = new int[n+1][2][3];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
        }
    }
    return memoization(prices,0,1,2,dp);
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

}