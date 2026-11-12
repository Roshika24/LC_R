class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
       PriorityQueue<Integer> avl = new PriorityQueue<>(
    (a, b) -> {
        if (servers[a] != servers[b]) {
            return Integer.compare(servers[a], servers[b]);
        }
        return Integer.compare(a, b);
    }
);
        for(int i=0;i<servers.length;i++){
                 avl.offer(i);
        }
        int [] ans=new int[tasks.length];
       // Arrays.fill(ans,-1);
        PriorityQueue<long []> tq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        int j=0;
        long t=0;
       
        while(j<tasks.length){
            while(!tq.isEmpty() && tq.peek()[0]<=t){
                avl.offer((int)tq.poll()[1]);
            }
            while(!avl.isEmpty()  && j<ans.length && (long)j <= t){
                int n=avl.poll();
                ans[j]=n;
                tq.offer(new long[]{(long)tasks[j]+t,(long)n});
                j++;
            }
           if(avl.isEmpty()){
            if(!tq.isEmpty())t=tq.peek()[0];
           }
            t=Math.max(t,(long)j);
        }

        return ans;
    }
}