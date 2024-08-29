class Solution {
    public int minDistance(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int[][] dp = new int[i+1][j+1];
        // return recursion(s,t,i,j);
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        return memoization(s,t,i,j,dp);
    }

    private int recursion(String s , String t , int i , int j){
        if(j<0){
            return i+1;
        }

        if(i<0){
            return j+1;
        }

        if(s.charAt(i) == t.charAt(j)){
            return 0 + recursion(s,t,i-1,j-1);
        }else{
            // insert
           int a = 1 + recursion(s,t,i,j-1);
           // delete
           int b = 1 + recursion(s,t,i-1,j);
           // replace
           int c = 1+ recursion(s,t,i-1,j-1);
           return Math.min(a,Math.min(b,c));
        }
    }

    private int memoization(String s , String t , int i , int j ,int[][]dp){
        if(j<0){
            return i+1;
        }

        if(i<0){
            return j+1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = 0 + memoization(s,t,i-1,j-1,dp);
        }else{
            int a = 1 + memoization(s,t,i,j-1,dp);
            int b = 1 + memoization(s,t,i-1,j,dp);
            int c = 1 + memoization(s,t,i-1,j-1,dp);
            dp[i][j] = Math.min(a,Math.min(b,c));
        }
        return dp[i][j];
    }
}