class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // int sum = (n)*(n+1)/2;
        // int sum2=0;
        // for(int i=0;i<n;i++){
        //     sum2 += nums[i];
        // }
        // return sum -sum2;
        int a =0;
        for(int i=0;i<=nums.length;i++){
           a=a^i;
        }
        int b =0;
       for(int i=0;i<nums.length;i++){
        b = b ^ nums[i];
       }
       return a^b;
    }
}