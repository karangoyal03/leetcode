class Solution {
    // public int maxScore(int[] cardPoints, int k) {
    //  int left = 0;
    //  int right = cardPoints.length-1;
    //  int leftSum = 0;
    //  int rightSum = 0;
    //  int maxSum = 0;
    // while(left<k){
    //     leftSum+= cardPoints[left];
    //     left++;
    // }
    // maxSum = leftSum+rightSum;
    // int count = 0;
    // left =left-1;
    // while(count<k) {
    //     leftSum = leftSum - cardPoints[left];
    //     rightSum = rightSum + cardPoints[right];
    //     left--;
    //     count++;
    //     right--;
    //     maxSum = Math.max(maxSum , leftSum+rightSum);
    // }
    // return maxSum;

   // }

    public int maxScore(int[] cardPoints, int k) {
       int leftSum =0;
       int rightSum =0;
       int left =0;
       while(left<k){
        leftSum+=cardPoints[left];
        left++;
       }
       int right =cardPoints.length-1;
       int maxSum = leftSum + rightSum;
               left = left-1;
            int count =0;
       while(count<k) {

        leftSum = leftSum - cardPoints[left];
        left--;
        rightSum = rightSum +cardPoints[right];
        right--;
        count++;
        maxSum = Math.max(maxSum , leftSum + rightSum);
       }
       return maxSum;
    }
}