class Solution {
    public boolean canFinish(int V, int[][] edges) {
         
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(v).add(u);
        }
        int [] vis=new int[V];
        for(int i=0;i<V;i++){
             if(vis[i]==0) 
             if(hasCycle(adj,i,vis)){
                return false;
             }
        }
    
         return true;
    }
    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int s,int [] vis){
        vis[s]=1;
        
        for(int nbr:adj.get(s)){
            if(vis[nbr]==0){
                if(hasCycle(adj,nbr,vis)) return true;
            }
            else if(vis[nbr]==1)return true;
        }
        vis[s]=2;
       // st.add(s);
        return false;
    }

}