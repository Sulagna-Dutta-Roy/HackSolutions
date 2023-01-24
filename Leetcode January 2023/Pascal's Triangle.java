class Solution {
    public List<Integer> getRow(int rowIndex) {
       int n=rowIndex;
       List<Integer> res=new ArrayList<Integer>();
       res.add(1);
        for(int i=1;i<=n;i++)
        {
           int x= (int) ( ((long)res.get(res.size()-1)*(n-i+1) ) /i);
           res.add(x);
        }
        return res;
    }
}
