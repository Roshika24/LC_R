class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

       ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
       for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
       }
       for(int i=0;i<edges.length;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        adj.get(u).add(v);
        adj.get(v).add(u);
       }
       boolean [] vis=new boolean[n+1];
       vis[source] = true;
       boolean ans =vpp(adj,source,destination,false,vis);
       return ans;
    }
    public static boolean vpp(ArrayList<ArrayList<Integer>> adj,int s, int d,boolean c, boolean [] vis){
        if(s==d)return true;
        for(int nbr:adj.get(s)){
            if(c)break;
            if(!vis[nbr]){
               // System.out.println(nbr);
                vis[nbr]=true;
                c=vpp(adj,nbr,d,c,vis);
                if(c==true)return true;
            }
        }
       
        return false;
    }
}