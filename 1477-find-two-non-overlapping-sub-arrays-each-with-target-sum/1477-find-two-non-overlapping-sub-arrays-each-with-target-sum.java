class Solution {
    public int minSumOfLengths(int[] arr, int tar) {
        int cut=arr.length-1;
        int min=Integer.MAX_VALUE;
        int [] left=new int[arr.length];
        int inf=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int len=Integer.MAX_VALUE;
        int s=0;
        while(i<arr.length){
           s+=arr[i];
           while(j<=i && s>tar){
            s-=arr[j];
            j++;
           }

           if(s==tar){len=Math.min(len,i-j+1);
              
           }
           left[i]=len;
           i++;
        }
        int [] right=new int[arr.length];
       s=0;
        i=arr.length-1;
        j=arr.length-1;
        len=Integer.MAX_VALUE;
        
        while(i>=0){
           s+=arr[i];
           
           while(j>=i && s>tar){
            s-=arr[j];
            j--;
           }

           if(s==tar){len=Math.min(len,j-i+1);
              
           }
           right[i]=len;
           i--;
        }
        
        for(int k=0;k<cut;k++){
            if(left[k]!=inf && right[k+1]!=inf)min=Math.min(left[k]+right[k+1],min);
            if(min==2)break;
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
    
}