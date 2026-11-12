class Solution {
    public int countServers(int[][] grid) {
        int a=0;
        Queue<int []> q=new LinkedList<>();
        int [][]moves={{0,-1},{0,1},{1,0},{-1,0}};
        for(int k=0;k<grid.length;k++){
           for(int l=0;l<grid[0].length;l++){
          int ans=1;
          if(grid[k][l]==1) {
            q.offer(new int[]{k,l});
            grid[k][l] = 0;
          while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
               int [] arr=q.poll();
               int r=arr[0],c=arr[1];
               for(int j=0;j<grid[0].length;j++){
                if(grid[r][j]==1 && j!=c){
                   grid[r][j]=0;
                       q.offer(new int[]{r,j});
                       ans++;
                }
               } 
               for(int j=0;j<grid.length;j++){
                if(grid[j][c]==1 && j!=r){
                   grid[j][c]=0;
                       q.offer(new int[]{j,c});
                       ans++;
                }
               }
            }
        }
       if(ans>1) {
        a+=ans;
       grid[k][l]=0;
        }}
        }
        }
       return a;
       
    }
}