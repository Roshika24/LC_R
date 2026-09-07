class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis =new boolean[rooms.size()];
        dfs(rooms,0,vis);
        for(int i=0;i<vis.length;i++){
            //System.out.print(vis[i]+" "+i);
            if(!vis[i])return false;
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, int s,boolean[] vis){
        vis[s]=true;
        for(int nbr:rooms.get(s)){
            if(!vis[nbr]){
                   dfs(rooms,nbr,vis);
            }
        }
    }
}