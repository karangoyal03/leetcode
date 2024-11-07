class Solution {
    public int majorityElement(int[] nums) {
        int candi = nums[0];
        int count =1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==candi){
                count++;
            }else{
                count--;
                if(count ==0){
                    candi = nums[i];
                    count=1;
                }
            }
        }

        int candiCount =0;
        for(int num : nums){
            if(candiCount > nums.length/2){
                break;
            }
            if(candi == num){
                candiCount++;
            }
        }
        return candi;
    }
}