class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> avl=new TreeSet<>();
        for(int i=0;i<k;i++){
            avl.add(i);
        } 
        int [] count=new int [k];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a[0], b[0])
);
        for(int i=0;i<arrival.length;i++){
            int m=i%k;
            while(!pq.isEmpty() && pq.peek()[0]<=arrival[i]){
                int [] arr=pq.poll();
                avl.add(arr[1]);
            }
            if(avl.ceiling(m)!=null){
                count[avl.ceiling(m)]++;
                pq.offer(new int[]{arrival[i]+load[i],avl.ceiling(m)});
                avl.remove(avl.ceiling(m));
            }
            else if(!avl.isEmpty()){
                 count[avl.first()]++;
                pq.offer(new int[]{arrival[i]+load[i],avl.first()})  ;
                avl.remove(avl.first());
            }
        }
        int ans=-1;
        int max=-1;
        for(int i=0;i<k;i++){
            if(count[i]>max){
                ans=i+1;
                max=count[i];
            }
        }
        ArrayList<Integer> ll=new ArrayList<>();
        for(int i=0;i<k;i++){
            if(count[i]==max){
                ll.add(i);
            }
        }
        return ll;
    }
}