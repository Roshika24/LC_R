class Solution {
    public int maxDistance(int[][] grid) {
        int [][] ans=new int[grid.length][grid.length];
        Queue<int []> q=new LinkedList<>();
        boolean one=false;
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else{
                    one =true;
                     ans[i][j]=-1;}
            }
        }
       if(!one) return -1;
       int c=0;
       if(q.isEmpty())return -1;
       int [][] moves={{1,0},{-1,0},{0,1},{0,-1}};
       while(!q.isEmpty()){
        c++;
        int s=q.size();
        for(int i=0;i<s;i++){
            
            int [] arr=q.poll();
            for(int j=0;j<4;j++){
                int cr=arr[0]+moves[j][0];
                int cc=arr[1]+moves[j][1];
                if(cr>=0 && cc>=0 && cr<grid.length && cc<grid.length && ans[cr][cc]==-1){
                     ans[cr][cc]=c;
                    q.offer(new int []{cr,cc});
                   
                }
            }
                    }
       }
       return c-1;
    }
}