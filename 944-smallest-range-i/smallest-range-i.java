class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }
        return (max - k) - (min + k) < 0 ? 0 : (max - k) - (min + k);
    }
}