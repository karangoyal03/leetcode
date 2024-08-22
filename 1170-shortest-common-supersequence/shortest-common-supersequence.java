class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        return lcs(str1,str2,n1,n2);
    }

    private String lcs(String str1  , String str2 , int n1 , int n2) {
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            dp[i][0] =0;
        }

        for(int i=0;i<=n2;i++){
            dp[0][i] =0;
        }

        for(int i=1;i<=n1;i++){

            for(int j=1;j<=n2;j++){

                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 +dp[i-1][j-1];
                }else{
                    dp[i][j] = 0  + Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

  int len = dp[n1][n2];
  int i = n1;
  int j = n2;

  int index = len - 1;
  String ans = "";
  while(i>0 && j>0) {
     if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
      ans += str1.charAt(i-1);
      index--;
      i--;
      j--;
    } else if (dp[i - 1][j] > dp[i][j - 1]) {
        ans += str1.charAt(i-1);
        i--;
    } else {
        ans += str2.charAt(j-1);
        j--;
    }
  }

  while(i>0){
      ans += str1.charAt(i-1);
      i--;
  }
  while(j>0){
      ans += str2.charAt(j-1);
      j--;
  }

  String ans2=new StringBuilder(ans).reverse().toString();
  return ans2;
    
    }
}