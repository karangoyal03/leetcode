class Solution {
  int[] pfx;
  int sum;

  public Solution(int[] w) {
    pfx = new int[w.length];

    pfx[0] = w[0];

    for (int i = 1; i < w.length; i++) {
      pfx[i] = pfx[i - 1] + w[i];
    }

    sum = pfx[pfx.length - 1];
  }

  public int pickIndex() {
      Random random = new Random();
      int randomNumber = random.nextInt( 0 , sum);

      return binarySearch(randomNumber);
    }

    private int binarySearch(int target){
      int l = 0;
      int r = pfx.length - 1;
     // int res = -1;

      while(l <= r){
        int m = l + (r-l)/2;

        if(pfx[m] > target ){
       //   res = m;
          r = m - 1;
        } else{
          l = m + 1;
        }
      }

      return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */