class Solution {
    List<Integer> allSubarrays = new ArrayList<>();
    public int rangeSum(int[] nums, int n, int left, int right) {
        generateAllSubarraysSum(nums,n,0);
        Collections.sort(allSubarrays);
        // System.out.println(allSubarrays);
        left = left -1;
        right = right -1;
        int sum =0;
        for(int i = left;i<=right;i++){
            sum+=allSubarrays.get(i);
            sum = sum%(int)(1e9+7);
        }
        return sum;
    }

     private void generateAllSubarraysSum(int[] nums, int n, int indx) {
        if (indx == n) {
            return;
        }
        int sum = 0;
        for (int end = indx; end < n; end++) {
            sum += nums[end];
            allSubarrays.add(sum%(int)(1e9+7));
        }
        generateAllSubarraysSum(nums, n, indx + 1);
    }
}