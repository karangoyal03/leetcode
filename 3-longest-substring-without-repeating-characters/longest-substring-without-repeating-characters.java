class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //   int count = 0;
    //   for(int i=0;i<s.length();i++){
    //     char ch = s.charAt(i);
    //     int temp =1;
    //     for(int j=i+1;j<s.length();j++){
    //         if(ch == s.charAt(j)){
    //             System.out.println("hey for value" + ch);
    //             break;
    //         }
    //         temp++;
    //     }
    //     System.out.println("value for temp " + temp);
    //     count = Math.max(count,temp);
    //   } 
    //   return count; 

    // substring nikalenge 
    // ek array maintain krenge agr woh character phele ayaa hua toh 
    // int maxLength = 0;
    // for(int i=0;i<s.length();i++){
    //         int[] hash = new int[256];
    //         int len =0;
    //     for(int j=i;j<s.length();j++){
    //        // is present in that array then break;
    //        int val = (int) s.charAt(j);
    //        if(hash[val] == 1){
    //         break;
    //        }else{
    //         len = j-i+1;
    //         maxLength = Math.max(len,maxLength);
    //         hash[val] =1;
    //        }

    //     }
    // }
    // return maxLength;

    // 2 pointer and sliding window approach

    // int l = 0;
    // int r = 0;
    // int maxLength =0;
    // HashMap<Character,Integer> map = new HashMap<>();
    // while(r<s.length()){  
    //     char ch = s.charAt(r);
    //     if(map.get(ch)!=null){
    //         if(map.get(ch)>= l){
    //             l = map.get(ch)+1;         
    //         }     
    //     }
    //     map.put(ch,r);
    //     int len = r-l+1;
    //     maxLength = Math.max(len,maxLength);
    //     r = r+1;
    // }
    // return maxLength;

    // }

     public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right =0;
        int maxLength =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            char ch = s.charAt(right);

            if(map.get(ch)!=null){
                if(map.get(ch)>=left){
                    left = map.get(ch)+1;
                }
            }

            map.put(ch,right);
            int len = right -left+1;
            maxLength = Math.max(maxLength,len);
            right = right +1;
        }
        return maxLength;
     }
}