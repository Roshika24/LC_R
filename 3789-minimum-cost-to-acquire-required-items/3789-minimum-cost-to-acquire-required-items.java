class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long x=(long)Math.max(need1,need2);
        long ans=Long.MAX_VALUE;
        
        long both=(cost1*(long)need1)+(cost2*(long)need2);
        long one=x*costBoth;
        ans=Math.min(both,one);
        ans=Math.min(ans,(Math.min(need1,need2)*(long)(costBoth-cost1-cost2))+both);
             return ans;
    }
}