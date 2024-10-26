class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
         result = new ArrayList<>();
         check(digits,0,new StringBuilder());
         return result;
    }

    private void check(String digits , int indx , StringBuilder sb){
        if(indx == digits.length()){
            if(sb.isEmpty()){
                return;
            }
            result.add(sb.toString());
            return;
        }

       for(char ch : getMapping(digits.charAt(indx)).toCharArray()){
        sb.append(ch);
        check(digits,indx+1,sb);
        sb.deleteCharAt(sb.length()-1);
       }
    }

    private String getMapping(char n){
        if(n == '2'){
            return "abc";
        }else if(n == '3'){
            return "def";
        }else if(n == '4'){
            return "ghi";
        }else if(n == '5'){
            return "jkl";
        }else if(n == '6'){
            return "mno";
        }else if(n == '7' ){
            return "pqrs";
        }else if(n == '8'){
            return "tuv";
        }else if(n== '9'){
            return "wxyz";
        }else{
            return "";
        }
    }
}