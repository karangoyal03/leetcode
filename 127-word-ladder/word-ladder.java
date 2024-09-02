class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Queue<String[]> queue = new LinkedList<>();
       queue.add( new String[]{beginWord,"1"});
       Set<String> set = new HashSet<>();
       for(String str : wordList){
        set.add(str);
       }
       set.remove(beginWord);
       while(!queue.isEmpty()){
            String[] entry = queue.remove();
            String word = entry[0];
            int step = Integer.parseInt(entry[1]);
            if(word.equals(endWord) == true) return step;
            for(int i=0;i<word.length();i++){
                for(char ch = 'a' ; ch<='z';ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                     if (set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        
                        queue.add(new String[]{replacedWord,step+1+""});
                    }
                }
            }
       }

       return 0;

    }
}