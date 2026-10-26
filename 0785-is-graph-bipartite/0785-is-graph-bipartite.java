class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!dfs(graph, color,0, i))return false;
            }
        }
        return true;
    }
    public boolean dfs(int [][] g, int [] color ,int col, int node){
        color[node]=col;
        for(int nbr:g[node]){
            if(color[nbr]==-1){
                if(!dfs(g,color,1-col,nbr))return false;
            }
            else if(color[nbr]==col)return false;
        }
        return true;
    }
}