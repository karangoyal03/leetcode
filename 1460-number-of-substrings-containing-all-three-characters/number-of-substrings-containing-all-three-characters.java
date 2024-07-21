class Solution {
    public int numberOfSubstrings(String s) {
        int right =0;
        int count = 0;
        int[] hash = new int[]{-1,-1,-1};

        while(right < s.length()){
            char ch = s.charAt(right);
           hash[ch - 'a'] = right;

            count = count  + (1  + Math.min(Math.min(hash[0], hash[1]), hash[2]));
    
           right++;
        }
        return count;
    }
}