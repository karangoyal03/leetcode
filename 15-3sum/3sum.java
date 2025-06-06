class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Map<Integer, Boolean> map = new HashMap<>();
        // Set<List<Integer>> set = new HashSet<>();
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length-2; i++) {
        //     if (i > 0 && nums[i] == nums[i - 1]) continue;
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int rem = 0 - (nums[i] + nums[j]);
        //          if (map.containsKey(rem)) {
        //             List<Integer> triplet = Arrays.asList(nums[i], nums[j], rem);
        //             set.add(triplet);
        //         }
        //         map.put(nums[j], true);

        //     }
        //     map.clear();
        // }
        // return new ArrayList<>(set);

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // ise uppr wale kabhi troplet bna hi nahi payenge
            if(nums[i]>0){
                break;
            }
            // same number walon ko ignore krdo
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }

            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }

        }
        return result;
    }
}