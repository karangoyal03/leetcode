class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low =1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }

        int high = max;
        while(low<=high){
            int mid = low + (high-low)/2;
            long totalHours = totalHoursCal(piles,mid);
            if(totalHours<=h){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }

        return low;

    }

    private long totalHoursCal(int[]piles , int rate){
        long totalHours =0;
        for(int i=0;i<piles.length;i++){
            totalHours += (long)Math.ceil((double)piles[i]/rate);
        }
        return totalHours;
    }
}