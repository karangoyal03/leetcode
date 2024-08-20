class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] val: dp) {
            Arrays.fill(val,-1);
        }
        return memoization(amount,coins,n-1,dp);
        // return recursion(amount,coins,n-1);
    }

    private int recursion(int amount , int[] coins , int indx) {
        if(indx ==0) {
            if(amount % coins[0] ==0){
                return 1;
            }else{
                return 0;
            }
        }

        int notTake = recursion(amount,coins,indx-1);
        int take =0;
        if(coins[indx]<=amount){
            take = recursion(amount-coins[indx],coins,indx);
        }
        return notTake  + take;
    }

    private int memoization(int amount , int[] coins , int indx , int[][]dp) {
        if(indx ==0) {
            if(amount % coins[0] ==0) {
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[indx][amount]!=-1){
            return dp[indx][amount];
        }

        int notTake = memoization(amount,coins,indx-1,dp);
        int take =0;
        if(coins[indx] <=amount){
            take = memoization(amount-coins[indx],coins,indx,dp);
        }
        dp[indx][amount] = notTake  + take;
        return dp[indx][amount];
    } 
}