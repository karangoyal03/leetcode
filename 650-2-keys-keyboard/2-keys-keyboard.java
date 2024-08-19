class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }

        return 1 + findMinSteps(1,1,n);

       
    }

    private int findMinSteps(int currentLength , int copyAns ,int n){
        if(currentLength == n){
            return 0;
        }
        if(currentLength > n) {
            return Integer.MAX_VALUE/2;
        }

        int copyAndPaste = 2 + findMinSteps(currentLength*2, currentLength,n);
        int paste = 1 + findMinSteps(currentLength + copyAns , copyAns,n);
        return Math.min(copyAndPaste,paste);

    }
}