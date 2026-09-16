class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ll=new ArrayList<>();
         int [] vis=new int[graph.length];
        for(int i=0;i<graph.length;i++){
           
            if(!dfs(vis,graph,i))ll.add(i);
        }
        return ll;
    }
     public boolean dfs( int [] vis,int [][] adj ,  int s){
        if(vis[s]!=0){
            return vis[s]==1;
        }
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