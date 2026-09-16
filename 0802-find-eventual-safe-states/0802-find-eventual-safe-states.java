class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ll=new ArrayList<>();
        
        for(int i=0;i<graph.length;i++){
            int [] vis=new int[graph.length];
            if(!dfs(vis,graph,i))ll.add(i);
        }
        return ll;
    }
     public boolean dfs( int [] vis,int [][] adj ,  int s){
        vis[s]=1;
        for(int nbr:adj[s]){
            if(vis[nbr]==0){
                
                if(dfs(vis,adj,nbr))return true;
            }
            else if(vis[nbr]==1)return true;
            
        }
        vis[s]=2;
        return false;
    }
}