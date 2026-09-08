class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int []> q=new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        int ini_color=image[sr][sc];
        boolean [][] vis=new boolean[image.length][image[0].length];
        image[sr][sc]=color;
        while(!q.isEmpty()){
           sr=q.peek()[0];
           sc=q.peek()[1];
           vis[sr][sc]=true;
           q.poll();
           for(int i=-1;i<=1;i+=2){
            int nr=sr+i;int nc=sc;
            if(nr>=0&& nc>=0 && nr<image.length && nc<image[0].length && !vis[nr][nc] && image[nr][nc]==ini_color){
                    vis[nr][nc]=true;
                    image[nr][nc]=color;
                    q.offer(new int[]{nr,nc});
                }
           }
           for(int i=-1;i<=1;i+=2){
            int nr=sr;
            int nc=sc+i;
            if(nr>=0&& nc>=0 && nr<image.length && nc<image[0].length && !vis[nr][nc] && image[nr][nc]==ini_color){
                    vis[nr][nc]=true;
                    image[nr][nc]=color;
                     q.offer(new int[]{nr,nc});
                }
           }
          
        }
        return image;
    }
}