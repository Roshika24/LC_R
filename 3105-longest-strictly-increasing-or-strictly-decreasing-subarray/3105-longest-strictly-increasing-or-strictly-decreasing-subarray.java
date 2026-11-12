class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int c=0;
        int max=1;
        int inc=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                if(inc==2){
                    c++;
                }
                else{
                    c=2;
                }
                inc=2;
            }
            else if(nums[i]>nums[i+1]){
                if(inc==1)c++;
                else c=2;
                inc=1;
            }
            else{
                c=0;
                inc=0;
            }
            max=Math.max(c,max);
           // System.out.println(inc+" "+c+" "+max);
        }
        return max;
    }
}