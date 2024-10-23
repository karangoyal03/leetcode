public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // long num = Integer.parseInt(Integer.toBinaryString(n));
        // long reverse = 0;
        // while(num!=0){
        //     long digit = num %10;
        //     reverse = reverse*10 + digit;
        //     num = num /10;
        // }

        // int val = Integer.parseInt(reverse+"" ,2);
        // return val;
        return Integer.reverse(n);


    }
}