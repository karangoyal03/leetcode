class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            check(s,0,new ArrayList<>());
            return ans;

    }

    private void check(String s , int indx , List<String> temp){
        if(indx == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = indx ; i<s.length();i++){
        String ss = s.substring(indx,i+1);
        if(checkForPalindrome(ss)){
            temp.add(ss);
            check(s,i+1,temp);
            temp.remove(temp.size()-1);
        }
        }
        
    }

    private boolean checkForPalindrome(String str){
        if (str.length() <= 1) return true;
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}