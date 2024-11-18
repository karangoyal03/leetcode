class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =piles[0];
        for(int i=1;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }
        int low =1;
        int high = max;
        while(low<=high){
            int mid = low + (high - low)/2;
            long totalHours = calculateTotalHours(piles,mid);
            if(totalHours<=h){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return low;

    }
    private long calculateTotalHours(int[] piles , int rate){
        long totalHours =0;
        for(int i=0;i<piles.length;i++){
            totalHours+= (long)Math.ceil((double)piles[i]/rate);
        }
        return totalHours;
    } 
}