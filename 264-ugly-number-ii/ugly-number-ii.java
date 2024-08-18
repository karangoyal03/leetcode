class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> ans = new ArrayList<>();
        int  i2=0;
        int i3=0;
        int i5=0;
        ans.add(1);
        for(int i=1;i<n;i++){
            int next = Math.min(ans.get(i2)*2 , Math.min(ans.get(i3)*3,ans.get(i5)*5));
            ans.add(next);
            if(next == ans.get(i2)*2){
                i2+=1;
            }
            if(next ==ans.get(i3)*3) {
                i3+=1;
            }
            if(next ==ans.get(i5)*5){
                i5+=1;
            }
        }

        return ans.get(n-1);
    }
}