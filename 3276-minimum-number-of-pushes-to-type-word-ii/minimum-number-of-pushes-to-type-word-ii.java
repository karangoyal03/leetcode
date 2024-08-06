class Solution {
    public int minimumPushes(String word) {
        int res =0;
        int count =0;
        int[] freq = new int[26];

        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        for(int i=25 ; i>=0;i--){
            if(freq[i]>0){
                res +=freq[i] * (count++/8 +1);
            }
        }

        return res;

    }
    
}