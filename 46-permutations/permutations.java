class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            recursive(nums,new ArrayList<>());
            return ans;

    }

    private void recursive(int[] nums ,List<Integer> temp){

       
            if(temp.size() == nums.length){
                ans.add(new ArrayList<>(temp));
                 return;
            }

            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                recursive(nums,temp);
                temp.remove(temp.size()-1);
            }

    }
}