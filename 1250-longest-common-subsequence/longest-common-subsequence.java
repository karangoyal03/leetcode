class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        // return recursion(text1,text2,n1-1,n2-1);
        int[][] dp = new int[n1+1][n2+1];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        // return memoization(text1,text2,n1-1,n2-1,dp);
        return tabulation(text1,text2,n1,n2,dp);
    }

    private int recursion(String text1 , String text2,int indx1 , int indx2) {
        if(indx1 < 0  || indx2 < 0){
            return 0;
        }

        if(text1.charAt(indx1) == text2.charAt(indx2)){
            return 1  + recursion(text1,text2,indx1-1,indx2-1);
        }else{
            return 0 + Math.max(recursion(text1,text2,indx1-1,indx2),recursion(text1,text2,indx1,indx2-1));
        }
    }

    private int memoization(String text1, String text2, int i1 , int i2, int[][]dp) {
        if(i1 < 0  || i2<0){
            return 0;
        }

        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }

        if(text1.charAt(i1) == text2.charAt(i2)){
            return dp[i1][i2] =  1 + memoization(text1,text2,i1-1,i2-1,dp); 
        }else{
            return dp[i1][i2] = 0 + Math.max(memoization(text1,text2,i1-1,i2,dp),memoization(text1,text2,i1,i2-1,dp));
        }
    }

    private int tabulation(String text1, String text2, int n1, int n2,int[][]dp) {
        for(int i=0;i<=n1;i++){
            dp[i][0] =0;
        }
        for(int i=0;i<=n2;i++){
            dp[0][i] =0;
        }

        for(int i=1;i<=n1;i++){
            for(int j =1 ;j<=n2;j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j]  = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] =  0 + Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }


}