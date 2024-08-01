class Solution {
    public int countSeniors(String[] details) {
        int count =0;
        for(String val : details) {
            String temp = val.substring(11,13);
            if(Integer.parseInt(temp)>60){
                count++;
            }
        }
        return count;
    }
}