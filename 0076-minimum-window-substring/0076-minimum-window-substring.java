class Solution {
    public String minWindow(String s, String t) {
      if(s.length()<t.length())return "";
      HashMap<Character,Integer> mp=new HashMap<>();
      HashMap<Character,Integer> curr=new HashMap<>();
      
      for(int i=0;i<t.length();i++){
        mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        curr.put(t.charAt(i),0);
        
      }
      int idxi=0;
      int idxj=0;
      int min=Integer.MAX_VALUE;
      int i=0;int j=0;
      int f=0;
      //int len=Integer.MAX_VALUE;
      while(i<s.length()){
        if(mp.containsKey(s.charAt(i))){
            int c=mp.get(s.charAt(i));
        int p=curr.get(s.charAt(i))+1;
        

        if(p<=c){
           f++;
        }
        curr.put(s.charAt(i),p);
        
           while(j<=i && f==t.length()){
             if(mp.containsKey(s.charAt(j))){
                 int hcur=mp.get(s.charAt(j));
                 int cur=curr.get(s.charAt(j))-1; 
                 curr.put(s.charAt(j),cur);
                 if(cur<hcur){
                    f--;
                 }
                int windowLen = i-j+1;

                if(windowLen < min){
                    min=windowLen;
                    idxi=i;idxj=j;
                 }
                 j++;
             }
             else j++;
           }
             
           
        }
        i++;
      }
    if(min == Integer.MAX_VALUE)
            return "";

        return s.substring(idxj, idxi + 1);
    }
}