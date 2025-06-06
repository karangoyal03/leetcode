class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                int rem = 0 - (nums[i] + nums[j]);
                 if (map.containsKey(rem)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], rem);
                    set.add(triplet);
                }
                map.put(nums[j], true);

            }
            map.clear();
        }
        return new ArrayList<>(set);
    }
}