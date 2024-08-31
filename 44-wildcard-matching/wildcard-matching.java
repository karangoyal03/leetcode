class Solution {
    public boolean isMatch(String s, String p) {
        int i = s.length() - 1;
        int j = p.length() - 1;
        int[][] dp = new int[i+1][j+1];
        for(int[] val : dp){
            Arrays.fill(val,-1);
        }
        return memoization(s,p,i,j,dp);
        // return recursion(s, p, i, j);
    }

    private boolean isAllStars(String str, int indx) {
        for (int i = 0; i <= indx; i++) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private boolean recursion(String s, String p, int i, int j) {

       if (i < 0 && j < 0) {
        return true;
    }

    if (j < 0 && i >= 0) {
        return false;
    }

    if (i < 0 && j >= 0) {
        return isAllStars(p, j);
    }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return recursion(s, p, i - 1, j - 1);
        } else {
            if (p.charAt(j) == '*') {
                return recursion(s, p, i - 1, j) || recursion(s, p, i, j - 1);
            } else {
                return false;
            }
        }
    }

    private boolean memoization(String s , String p , int i , int j , int[][]dp){
        if(i < 0 && j < 0){
            return true;
        }

        if( j < 0 && i>=0){
            return false;
        }

        if(i< 0 && j >=0){
            return isAllStars(p,j);
        }

        if(dp[i][j] !=-1){
            return dp[i][j] == 0 ? false : true; 
        }

        if(s.charAt(i) == p.charAt(j)  || p.charAt(j) == '?'){
            boolean res = memoization(s,p,i-1,j-1,dp);
            dp[i][j] = res? 1:0;
            return res;
        }else{
            if(p.charAt(j) == '*'){
                boolean ress = memoization(s,p,i-1,j,dp) || memoization(s,p,i,j-1,dp);
                dp[i][j] = ress ? 1:0;
                return ress;
            }else{
                dp[i][j] = 0;
                return false;
            }
        }
    }

}