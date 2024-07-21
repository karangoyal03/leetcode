class Solution {
    public int longestOnes(int[] nums, int k) {
        // approach 1 

        // int left =0;
        // int right = 0;
        // int maxLength = 0;
        // int zeroCount =0;
        // while(right < nums.length){
        //     int len =0;
        //     if(nums[right] == 0){
        //         zeroCount++;
        //     }
        //     if(zeroCount>k){
        //         if(nums[left] == 0){
        //             zeroCount--;
        //         }
        //         left++;
        //     }
        //     if(zeroCount<=k){
        //         len = right-left+1;  
        //         maxLength = Math.max(maxLength,len);
        //     }
        //      right++;
        // }
        // return maxLength;


        int left =0;
        int right =0;
        int n = nums.length;
        int maxLength =0;
        int zeroCount=0;
        while(right<n) {
            if(nums[right]==0){
                zeroCount++;
            }

            if(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                } 
                left = left +1;
            }


            if(zeroCount<=k){
                int len = right -left +1;
                maxLength = Math.max(len,maxLength);
            }
            right = right +1;

        }
        return maxLength;
    }
}