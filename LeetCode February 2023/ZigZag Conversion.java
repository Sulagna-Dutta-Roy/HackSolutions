class Solution {
    public String convert(String s, int numRows) {
       List<List<Character>> l=new ArrayList<>();
       if(numRows==1)return s;
       for(int i=0;i<numRows;i++)
       {
           l.add(new ArrayList<>());
       } 
       int row=0;
       int t=0;
       for(int i=0;i<s.length();i++)
       {
           l.get(row).add(s.charAt(i));
           if(t==0)row++;
           else row--;
           if(row==0||row==numRows-1)t=t==0?1:0;
       }
       String res="";
       for(List l1:l)
       {
           for(int i=0;i<l1.size();i++)res+=(""+l1.get(i));
       }
    return res;
    }
}
