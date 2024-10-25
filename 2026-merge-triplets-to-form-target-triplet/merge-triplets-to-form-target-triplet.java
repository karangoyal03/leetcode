class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();

        for(int[] trip : triplets) {
            if(trip[0]> target[0] || trip[1]> target[1] || trip[2]> target[2]){
                continue;
            }

            for(int i=0;i<trip.length;i++){
                if(trip[i] == target[i]){
                    good.add(i);
                }
            }
        }

        return good.size() ==3;

    }
}