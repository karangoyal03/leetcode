public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left =0;
        int right = 31;
        String binaryString = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
       char[] charArray = binaryString.toCharArray();
        while(left<right){
           char temp = charArray[left];
           charArray[left] = charArray[right];
           charArray[right] = temp;
           left++;
           right--;
        }
        String numberString = new String(charArray);
        return Integer.parseUnsignedInt(numberString, 2);
    }
}