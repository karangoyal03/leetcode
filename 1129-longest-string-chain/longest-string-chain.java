class Solution {
    public int longestStrChain(String[] words) {
         Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
         int[] dp = new int[words.length];
         int n = words.length;
         Arrays.fill(dp,1);
         int max =1;
        for(int i =0;i<n;i++){
            for(int prev = 0 ; prev<i;prev++){


                if(checkForPossibility(words[i], words[prev]) && 1 + dp[prev]> dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    private boolean checkForPossibility(String curr , String prev){
        if(curr.length() != prev.length()+1){
            return false;
        }

        int one =0;
        int two =0;

        while(one<curr.length()){
            if(two < prev.length() && curr.charAt(one) == prev.charAt(two)){
                one ++;
                two++;
            }else{
                one++;
            }
        }

        return one==curr.length() && two == prev.length();
    }
}