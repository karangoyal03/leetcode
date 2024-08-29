class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int[][] dp = new int[i+1][j+1];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        // return recursion(s,t,i,j);
        return memoization(s,t,i,j,dp);
    }

    private int recursion(String s , String t , int i , int j) {
        if(j<0) {
            return 1;
        }

        if(i<0){
            return 0;
        }

        if(s.charAt(i) == t.charAt(j)){
           return  recursion(s,t,i-1,j-1) + recursion(s,t,i-1,j);
        }else {
            return recursion(s,t,i-1,j);
        }
    }

    private int memoization(String s , String t , int i , int j , int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = memoization(s,t,i-1,j-1,dp) + memoization(s,t,i-1,j,dp);
        }else{
            dp[i][j] = memoization(s,t,i-1,j,dp);
        }

        return dp[i][j];
    }
}