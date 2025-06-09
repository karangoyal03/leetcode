class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        for(char ch : s.toCharArray()){
            smap.put(ch , smap.getOrDefault(ch,0)+1);
        }

        for(char ch : t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch,0)+1);
        }

        return smap.equals(tmap);
    }
}