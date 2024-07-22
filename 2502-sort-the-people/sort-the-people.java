public class Pair{
    String name;
    int height;

    public void setName(String name){
        this.name = name;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public String getName(){
        return this.name;
    }

    public int getHeight(){
        return this.height;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.getHeight(), p1.getHeight()); // Sorting in descending order of height
            }
        });
        for(int i=0;i<names.length;i++){
            Pair pair = new Pair();
            pair.setHeight(heights[i]);
            pair.setName(names[i]);
            pq.add(pair);
        }
        String[] result = new String[names.length];
        int count =0;
        while(!pq.isEmpty()){
           Pair a = pq.poll();
            result[count]=(a.getName());
            count++;
        }
        return result;
     }
}

