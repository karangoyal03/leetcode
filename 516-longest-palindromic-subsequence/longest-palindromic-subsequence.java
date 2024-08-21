class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n1 = s.length();
        int n2 = s2.length();
        return longestCommonSubSequence(s,s2,n1,n2);
    }

    private int longestCommonSubSequence(String s1 , String s2 , int n1 , int n2) {
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            dp[i][0] =0;
        }

        for(int i=0;i<=n2;i++){
            dp[0][i] =0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1  + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0  + Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}