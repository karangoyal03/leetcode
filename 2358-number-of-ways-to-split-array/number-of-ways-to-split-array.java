class Solution {
    public int waysToSplitArray(int[] nums) {
      long[] left = new long[nums.length];
      long[] right = new long[nums.length];

        left[0] = nums[0];
        right[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1]+nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1]+nums[i];
        }

        int count =0;
        for(int i=0;i<nums.length-1;i++){
            if(left[i]>=right[i+1]){
                count++;
            }
        }
        return count; 
    //   int n=nums.length;
    //     long sumTotal=0;
    //     long sumCurr=0;
    //     int cnt=0;

    //     // Calculate total sum
    //     for(int i=0; i<n; i++){
    //         sumTotal+=nums[i];
    //     }

    //     // Check valid splits condition
    //     for(int i=0; i<n-1; i++){
    //         sumCurr+=nums[i];
    //         if(sumCurr >= sumTotal-sumCurr){
    //             cnt++;
    //         }
    //     }

    //     return cnt;
}
}