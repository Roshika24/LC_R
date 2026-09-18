class Solution {
    public int[][] updateMatrix(int[][] mat) {
      
        int n=mat.length;
        int m=mat[0].length;
        int [][] ans=new int[n][m];
        Queue<int []> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    ans[i][j]=-1;
                }
                else {
                    ans[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }
       int c=0;
       int [][] moves={{1,0},{-1,0},{0,1},{0,-1}};
       
       while(!q.isEmpty()){
             c++;
            int s=q.size();
            for(int l=0;l<s;l++){
               int [] arr=q.poll();
               for(int k=0;k<4;k++){
               int cr=moves[k][0]+arr[0];
               int cc=moves[k][1]+arr[1];
                if(cr>=0 && cr<n && cc>=0 && cc<m &&  ans[cr][cc]==-1){
                   ans[cr][cc]=c;
                   q.offer(new int[]{cr,cc});
                }
              }
            }
       }
       return ans;
    }
}