class Solution {
    public int getLucky(String s, int k) {
     StringBuilder number = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        int c = (ch - 'a') + 1;
        number.append(c);
    }
    String numStr = number.toString();
    int sum = 0;
    String temp = numStr;
    for (int i = 0; i < k; i++) {
        sum = sumOfdigits(temp);
        temp = String.valueOf(sum);
    }
    return sum;
    }
    private int sumOfdigits(String num) {
    int sum = 0;
    for (int i = 0; i < num.length(); i++) {
        int a = Character.getNumericValue(num.charAt(i));
        sum += a;
    }
    return sum;
}
}