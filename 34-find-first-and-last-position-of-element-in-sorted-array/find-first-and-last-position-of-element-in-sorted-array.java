class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        ans[0] = lowerBound(nums,target);
        ans[1] = upperBound(nums,target);
        return ans;
    }

    private int lowerBound(int[] nums , int target){
        int low = 0;
        int high = nums.length-1;
        int ans =-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid]>=target){
                if(nums[mid]== target){
                ans = mid ;         
            }
            high = mid -1;
            }
           else{
                low = mid +1;
            }
        }
        return ans;
    }

    private int upperBound(int[]nums , int target){
        int low =0;
        int high = nums.length-1;
        int ans = -1 ;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid]<=target){
                if(nums[mid] == target){
                ans = mid; 
            }
            low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return ans;
    }
}