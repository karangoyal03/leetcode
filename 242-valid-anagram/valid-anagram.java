class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        int[] countt = new int[26];

        for(char ch : s.toCharArray()){
            counts[ch-'a']++;
        }

        for(char ch : t.toCharArray()){
            countt[ch-'a']++;
        }

        String s1 = Arrays.toString(counts);
        String s2 = Arrays.toString(countt);
        return s1.equals(s2);
    }
}