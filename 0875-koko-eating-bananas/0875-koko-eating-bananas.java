class Solution {
    public int minEatingSpeed(int[] piles, int h) {
   int l=1;
   int high= 1000000000;
   int ans=0;
   while(l<=high){
    int mid=l+(high-l)/2;
    if(mini(piles,h,mid)){
        ans=mid;
        high=mid-1;
    }
    else{
        l=mid+1;
    }
   }

   return ans;                
    }
    public static boolean mini(int[] piles, int h,int k){
        int i=0;
        int hrs=0;

        while(i<piles.length){
            int p=piles[i];
            int times=(p/k)+1;
            if(p%k==0)times-=1;
                hrs+=times;
                if(hrs>h){
                return false;
            }
             
             i++;
        }
       
        return true;
    }
}



   