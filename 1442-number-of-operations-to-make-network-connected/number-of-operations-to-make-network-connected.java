class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int countExtraEdges =0;
        int m = connections.length;

        for(int i=0;i<m;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                countExtraEdges++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int count =0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i) == i){
                count++;
            }
        }

        int ans = count - 1;
        if (countExtraEdges >= ans) return ans;
        return -1;
    }
}

public class DisjointSet {

  List<Integer> rank;
  List<Integer> parent;
  List<Integer> size;
  public DisjointSet(int n ){
    rank = new ArrayList<>();
    parent = new ArrayList<>();
    size = new ArrayList<>();
    for(int i = 0 ; i <= n ; i++){
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  public int findUPar(int node){
    if(node == parent.get(node)) return node;
    parent.set(node , findUPar(parent.get(node)));
    return parent.get(node);
  }

  public void unionBySize(int u , int v){
    int pu = findUPar(u);
    int pv = findUPar(v);
    if(pu == pv) return;

    int sizeU = size.get(pu);
    int sizeV = size.get(pv);

    if(sizeU > sizeV){
      parent.set(pv , pu);
      size.set(pu , sizeU + sizeV);
    } else{
      parent.set(pu ,  pv);
      size.set(pv , sizeV + sizeU);
    }
  }

  public void unionByRank(int u , int v){
    int pu = findUPar(u);
    int pv = findUPar(v);

    if(pu == pv) return;
    int rankU = rank.get(pu);
    int rankV = rank.get(pv);

    if(rankU > rankV){
      parent.set(pv , pu);
    } else if(rankU < rankV){
      parent.set(pu , pv);
    } else {
      parent.set(pu , pv);
      rank.set(pv , rankV + 1);
    }
  }
}