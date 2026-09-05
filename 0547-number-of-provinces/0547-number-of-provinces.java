class Solution {
    static int c=0;
    public int findCircleNum(int[][] isConnected) {
        c=0;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<=isConnected.length;i++){
         adj.add(new ArrayList<>() );
    }
    for(int i=0;i<isConnected.length;i++){
        for(int j=0;j<isConnected[i].length;j++){
            if(i!=j && isConnected[i][j]==1)adj.get(i+1).add(j+1);
        }
    }
    int [] vis=new int[adj.size()];
     int count=0;
     boolean [] v2=new boolean[adj.size()];
        for(int i=1;i<adj.size();i++){
            if(vis[i]==0){
                count++;
                vis[i]=1;
               
                    dfs(adj,v2,vis,i);
                
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean [] vis,int [] v,int s){
       vis[s]=true;
       for(int nbr:adj.get(s)){
        if(!vis[nbr]){
            vis[nbr]=true;
            v[nbr]=1;
            dfs(adj,vis,v,nbr);}
       }
    }
}