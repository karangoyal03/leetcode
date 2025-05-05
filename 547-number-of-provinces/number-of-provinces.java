class Solution {
    int count =0;
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
            dfs(i,visited,adj);
            count++;
            }
        }

        return count;
    
    }

    public void dfs(int node , boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        for(int it : adj.get(node)){
            if(!visited[it]){
                dfs(it,visited,adj);
            }
        }
    }
}