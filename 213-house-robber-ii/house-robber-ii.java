class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }

        int[] firstLeftOut = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            firstLeftOut[i-1] = nums[i];
        }
        int[] lastLeftOut = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            lastLeftOut[i] = nums[i];
        }
        int [] dp = new int [firstLeftOut.length+1];
        Arrays.fill(dp,-1);
        int [] dp2 = new int [lastLeftOut.length+1];
        Arrays.fill(dp2,-1);
        // int first = recursion(firstLeftOut,firstLeftOut.length-1);
        // int second = recursion(lastLeftOut,lastLeftOut.length-1);
        // int first = recursion(firstLeftOut,firstLeftOut.length-1);
        int first = memoization(firstLeftOut,firstLeftOut.length-1,dp);
        int second = memoization(lastLeftOut,lastLeftOut.length-1,dp2);
        return Math.max(first,second);

    }

    private int recursion(int[] nums , int indx) {
        if(indx ==0){
            return nums[indx];
        }
        if(indx<0){
            return 0;
        }
        int pick  = recursion(nums,indx-2) + nums[indx];
        int notPick = recursion(nums,indx-1) + 0;
        return Math.max(pick,notPick);
    }

    private int memoization(int[] nums , int indx , int[] dp){
        if(indx==0){
            return nums[indx];
        }

        if(indx<0){
            return 0;
        }

        if(dp[indx]!=-1){
            return dp[indx];
        }
        int pick = memoization(nums,indx-2,dp)+nums[indx];
        int notPick = memoization(nums,indx-1,dp) +0;
        dp[indx] = Math.max(pick,notPick);
        return dp[indx];
    }

    private int tabulation() {
            return 0;
    }

    private int spaceOptimization(int[] arr){
            return 0;
    }
}