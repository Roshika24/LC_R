class Solution {
    public int missingMultiple(int[] nums, int k) {
       ArrayList<Integer> ll =new ArrayList<>();
       Arrays.sort(nums);
       int j=1;
       for(int i=0;i<nums.length;i++){
        if(i!=0 && nums[i]==nums[i-1])continue;
        if(nums[i]%k==0){
            if(nums[i]/k!=j)return k*j;
            j++;
        }
       }
       return k*j;
    }
}