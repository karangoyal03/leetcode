class Solution {
    public int minSwaps(int[] nums) {
        
        // int left =0;
        // int right =0;
        // int count =0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] == 1){
        //         count++;
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // int tempCount =0;
        // int n = nums.length;
        // while(right<n+count){
        //      tempCount += nums[right % n];

        //     if(right -left + 1 > count) {
        //             tempCount -= nums[left % n];
        //             left++;
        //          }

        // if(right - left + 1 == count) {
        //      min = Math.min(min, count - tempCount);
        //  }
        // }
        // return min;

    int l = 0;
    int n = nums.length;

    int res = Integer.MAX_VALUE;
    int count1 = 0;
    int ones = 0;

    for (int num : nums) {
      if (num == 1)
        ones++;
    }

    for (int r = 0; r < n+ones; r++) {
      count1 += nums[r % n];

      if (r - l + 1 > ones) {
        count1 -= nums[l % n];
        l++;
      }

      if (r - l + 1 == ones) {
        res = Math.min(res, ones - count1);
      }
    }

    return res;
    }

   
}