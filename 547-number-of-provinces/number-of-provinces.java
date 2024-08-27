class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = isConnected.length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j] ==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int count =0;
        for(int i =0;i<V;i++){
            if(visited[i] == false){
                count++;
                // dfs(i,adj,visited);
                bfs(i,adj,visited);
            }
        }

        return count;

    }

    private void dfs(int node ,ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for( int it : adj.get(node)){
            if(visited[it] == false){
                dfs(it,adj,visited);
            }
        }
    }

    private void bfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int it : adj.get(n)){
                if(visited[it] == false){
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
    }


}