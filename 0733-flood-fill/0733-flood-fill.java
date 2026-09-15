class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // code here
               int [][] arr=new int[image.length][image[0].length];
               boolean [][] vis=new boolean[arr.length][arr[0].length];
               for(int i=0;i<arr.length;i++){
                   for(int j=0;j<arr[0].length;j++){
                       arr[i][j]=image[i][j];
                   }
               }
               dfs(arr,sr,sc,color,image[sr][sc],vis);
               return arr;
               
    }
    public void dfs(int[][] img, int sr, int sc, int c,int ic,boolean [][] vis){
        vis[sr][sc]=true;
        img[sr][sc]=c;
        int [][] moves={
            {0,1},{0,-1},{-1,0},{1,0}
        };
        for(int i=0;i<moves.length;i++){
            int cr=sr+moves[i][0];
            int cc=sc+moves[i][1];
            if(cr>=0 && cr<img.length && cc>=0 && cc<img[0].length && img[cr][cc]==ic && !vis[cr][cc]){
                dfs(img,cr,cc,c,ic,vis);
            }
        }
        return;
    }
}