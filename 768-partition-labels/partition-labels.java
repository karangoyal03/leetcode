class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
          map.put(s.charAt(i), i);
           
        }
        int size =0;
        int end = 0;
        int i=0;
        List<Integer> ans = new ArrayList<>();
        while(i<s.length()){
            char ch = s.charAt(i);
            end = Math.max(end , map.get(ch));
            size++;
            if(i == end){
                ans.add(size);
                size=0;
            }
            i++;

        }
        return ans;
    }
}