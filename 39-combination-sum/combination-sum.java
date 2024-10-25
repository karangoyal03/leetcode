class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            recursive(candidates, target, 0, new ArrayList<>());
            return ans;
    }

    private void recursive(int[] candidates , int target , int indx ,List<Integer> temp){

        if(indx == candidates.length){
            if(target ==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[indx]<=target){
            temp.add(candidates[indx]);
            recursive(candidates,target - candidates[indx], indx,temp);
            temp.remove(temp.size()-1);
        }
        recursive(candidates,target,indx+1,temp);
    }
}