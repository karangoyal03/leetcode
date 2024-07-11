class Solution {
    public boolean canPartition(int[] nums) {

         int totalSum =0;
        for(int val:nums){
            totalSum+=val;
        }
        if(totalSum%2==1){
            return false;
        }else{
// it we get want to get two subset with equal sum then if i can get
            // any one subset with totalsum/2 then return true else false

       
        int n = nums.length;
        int subsetSum = totalSum/2;

        int[][]dp = new int[n+1][subsetSum+1];
        for(int[] val:dp){
            Arrays.fill(val,-1);
        }
        return memoization(nums,n-1,subsetSum,dp);
        // return recursion(nums,n-1,totalSum/2);
        }

            

    }

    private static boolean recursion(int[]arr , int indx , int sum) {
        if(sum ==0) {
            return true;
        }

        if(indx ==0) {
            return arr[0] == sum;
        }

        boolean notPick = recursion(arr,indx-1,sum);

        boolean pick = false;

        if(arr[indx]<=sum){
            pick = recursion(arr,indx-1,sum-arr[indx]);

        }
        return pick || notPick;
    }

    private static boolean memoization(int[] arr, int indx , int sum ,int[][]dp) {
        if(sum==0){
            return true;
        }

        if(indx ==0) {
            return arr[0] ==sum;
        }

        if(dp[indx][sum]!=-1){
            return dp[indx][sum] == 0 ? false:true;
        }

        boolean notPick = memoization(arr,indx-1,sum,dp);
        boolean pick = false;

        if(arr[indx]<=sum){
            pick =memoization(arr,indx-1,sum-arr[indx],dp);
        }

        boolean result = notPick || pick;
        dp[indx][sum] = result ? 1:0;
        return result;
    }
}