class Solution {
    public int coinChange(int[] coins, int amount) {
        int n =coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] val:dp){
            Arrays.fill(val,-1);
        }
        int ans = memoization(coins,amount,n-1,dp);
        // int ans =recursion(coins,amount,n-1);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    private int recursion(int[]coins , int amount , int indx) {
        if(indx ==0) {
            if(amount %coins[indx] ==0) {
                return amount/coins[indx];
            }else{
                return (int) Math.pow(10, 9);
            }
        }

        int notPick = 0+ recursion(coins,amount,indx-1);
        int pick =(int) Math.pow(10, 9);
        if(coins[indx]<=amount) {
            pick = 1+ recursion(coins,amount-coins[indx],indx);
        }

        return Math.min(notPick,pick);
    } 

    private int memoization(int[] coins , int amount , int indx , int[][]dp) {
        if(indx ==0) {
            if(amount %coins[indx] ==0) {
                return amount/coins[indx];
            }else{
                return (int)Math.pow(10,9);
           }
        }

        if(dp[indx][amount]!=-1){
            return dp[indx][amount];
        }

        int notPick = 0 + memoization(coins,amount,indx-1,dp);
        int pick = (int)Math.pow(10,9);
        if(coins[indx]<=amount){
            pick = 1 + memoization(coins,amount-coins[indx],indx,dp);
        }

        dp[indx][amount] = Math.min(notPick , pick);
        return dp[indx][amount];
    }
}