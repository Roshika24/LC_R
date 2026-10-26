class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
    }
    for(int i=0;i<dislikes.length;i++){
        int u=dislikes[i][0];
        int v=dislikes[i][1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    int [] color =new int [n+1];
    Arrays.fill(color,-1);
    for(int i=1;i<=n;i++){
   
    if(color[i]==-1){
    Queue<Integer> q=new LinkedList<>();
    color[i]=0;
    q.offer(i);
    while(!q.isEmpty()){
        int node=q.poll();
        for(int nbr:adj.get(node)){
            if(color[nbr]==-1){
                color[nbr]=1-color[node];
                q.offer(nbr);
            }
            else if(color[node]==color[nbr]){
                return false;
            }
            
        }
    } 
    }
    }
    return true;
    }
}