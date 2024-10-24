class Solution {
    public int jump(int[] nums) {
        // return minimumJumps(nums,0,0);
        // int[][] dp = new int[nums.length][nums.length];
        // for(int[] val : dp){
        //     Arrays.fill(val,-1);
        // }
        // return memoization(nums,0,0,dp);
        int left =0;
        int right =0;
        int res =0;
        while(right < nums.length-1){

        int farthest =0;
        for(int i = left ; i<=right ;i++){
            farthest = Math.max(farthest , i + nums[i]);
        }    

        // update the window 
        left = right+1;
        right = farthest;
        res= res+1;

        }
        return res;
    }

    // private int minimumJumps(int[] nums , int jump , int indx){
    //     if(indx>=nums.length-1){
    //         return jump;
    //     }
    //     int minimum = Integer.MAX_VALUE;
    //     for(int i=1 ;i<=nums[indx];i++){
    //         minimum = Math.min(minimum , minimumJumps(nums,jump+1,indx+i));
    //     }
    //     return minimum;
    // }

    // private int memoization(int[] nums , int jump ,int indx , int[][] dp){
    //     if(indx>=nums.length-1){
    //         return jump;
    //     }
    //     if(dp[indx][jump]!=-1){
    //         return dp[indx][jump];
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(int i=1;i<=nums[indx];i++){
    //         min = Math.min(min, memoization(nums, jump +1 , indx+i,dp));
    //     }
    //    dp[indx][jump] = min;
    //    return dp[indx][jump];
    // }

    // private int tabulation(int[] nums , int [][]dp){
    //      return dp[nums.length][nums.length];
    // }
}