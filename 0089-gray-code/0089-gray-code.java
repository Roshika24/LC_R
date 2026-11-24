class Solution {
    public List<Integer> grayCode(int n) {
       
    List<Integer> ll=new ArrayList<>();
    int l=(int)Math.pow(2,n);
    for(int i=0;i<l;i++){
        ll.add(i^(i>>1));
    }
    return ll;
    }
}