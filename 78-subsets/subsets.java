class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        recursionSubsets(nums,0 , new ArrayList<>());
        return ans;
    }

    private void recursionSubsets(int[] nums , int indx , List<Integer> temp){
        if(indx>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[indx]);
        recursionSubsets(nums,indx+1,temp);
        temp.remove(temp.size()-1);
         recursionSubsets(nums,indx+1,temp);
    }
}