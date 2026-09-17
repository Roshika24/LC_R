class Solution {
    public int[] findOrder(int V, int[][] edges) {
         Stack<Integer> st=new Stack<>();
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
             if(hasCycle(adj,st,i,vis)){
                return new int[0];
             }
        }
       int [] ans=new int[V];
       int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
         return ans;
    }
    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int s,int [] vis){
        vis[s]=1;
        
        for(int nbr:adj.get(s)){
            if(vis[nbr]==0){
                if(hasCycle(adj,st,nbr,vis)) return true;
            }
            else if(vis[nbr]==1)return true;
        }
        vis[s]=2;
        st.add(s);
        return false;
    }

    
    }
