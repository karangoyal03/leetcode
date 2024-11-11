class Solution {
  int[] pfx;
  int sum;

  public Solution(int[] w) {
    pfx = new int[w.length];
    pfx[0] = w[0];
    for(int i=1;i<w.length;i++){
        pfx[i] =pfx[i-1]+w[i];
    }
    sum = pfx[pfx.length-1];
  }

  public int pickIndex() {
        Random random = new Random();
        int randomIndex = random.nextInt(0,sum);
        return binarySearch(randomIndex);
    }

    private int binarySearch(int target){
        int left =0;
        int right = pfx.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(pfx[mid] <=target){
                left =mid+1;
            }else{
                right =mid-1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */