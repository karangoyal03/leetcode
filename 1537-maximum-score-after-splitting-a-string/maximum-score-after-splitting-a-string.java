class Solution {
    public int maxScore(String s) {
        int maxScore = Integer.MIN_VALUE;
        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            int score = countOccurence(left,'0') + countOccurence(right,'1');
            maxScore = Math.max(score,maxScore);
        }
        return maxScore;
    }

    public int countOccurence(String subs, char ch) {
        int count = 0;
            for(int i=0;i<subs.length();i++){
                if(subs.charAt(i)==ch){
                    count++;
                }
            }
            return count;
    }
}