class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0,src,0));
        int[] distance = new int[n];
        for(int i=0;i<distance.length;i++){
            distance[i] = (int)1e9;
        }
        distance[src] = 0;
        while(!queue.isEmpty()){
            Tuple tp = queue.remove();
            int stops = tp.first;
            int node = tp.second;
            int cost = tp.third;

            if(stops> k) continue;

            for(Pair pt : adj.get(node)){
                int nn = pt.first;
                int edgeWeight = pt.second;

                if(cost + edgeWeight < distance[nn] && stops<=k){
                    distance[nn] = cost + edgeWeight;
                    queue.add( new Tuple(stops+1,nn,distance[nn]));
                }
            }
        }
        if(distance[dst] ==(int)1e9)return -1;
        return distance[dst];
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first , int second , int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}