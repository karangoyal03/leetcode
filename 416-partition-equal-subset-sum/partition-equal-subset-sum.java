class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum =0;
        for(int i =0;i<nums.length;i++) {
            totalsum+=nums[i];
        }

        if(totalsum%2!=0) return false;
        else{
            int n = nums.length;
            // return recursion(nums,0,n,totalsum/2);
            int[][] dp = new int[n+1][totalsum/2+1];
            for(int[] val : dp) {
                Arrays.fill(val,-1);
            }
            // return memoization(nums,0,n,totalsum/2,dp);
            return tabulation(nums,totalsum/2,n);
        }
    }

    private boolean recursion(int[]nums , int indx , int n , int sum) {
        if(sum ==0 ){
            return true;
        }

        if(indx ==n) {
            return false;
        }

        boolean notPick = recursion(nums,indx+1,n,sum);
        boolean pick = false;
        if(nums[indx]<=sum) {
            pick = recursion(nums,indx+1,n,sum-nums[indx]);
        }

        return pick || notPick;
    }

    private boolean memoization(int[] nums , int indx , int n , int sum , int[][]dp) {
        if(sum ==0) {
            return true;
        }

        if(indx == n) {
            return false;
        }

        if(dp[indx][sum]!=-1){
            return dp[indx][sum] ==0 ? false: true;
        }

        boolean notPick = memoization(nums,indx+1,n,sum,dp);
        boolean pick = false;
        if(nums[indx]<=sum) {
            pick = memoization(nums,indx+1,n,sum-nums[indx],dp);
        }

        dp[indx][sum] = (pick || notPick) ? 1:0;
        return pick  || notPick;
    }

    private boolean tabulation(int [] arr , int sum , int n) {
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        if(arr[0]<=sum) {
            dp[0][arr[0]] = true;
        }

        for(int i=1;i<n;i++){
            for(int target =1; target<=sum ;target++) {


                boolean notPick = dp[i-1][target];
                boolean pick = false;
                if(arr[i] <=target) {
                    pick = dp[i-1][target-arr[i]];
                }

                dp[i][target] = (pick || notPick);
            }
        }

        return dp[n-1][sum];

    }
}