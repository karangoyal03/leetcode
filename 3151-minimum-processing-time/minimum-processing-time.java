class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
      Collections.sort(tasks, Collections.reverseOrder());
      Collections.sort(processorTime);
      int ans=0;
      int j=0;
      for(int i=0;i<processorTime.size();i++){
        ans = Math.max(ans , tasks.get(j)+processorTime.get(i));
        j=j+4;
      }
      return ans;


    }
}