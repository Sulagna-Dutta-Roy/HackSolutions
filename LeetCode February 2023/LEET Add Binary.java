class Solution {
    public String addBinary(String a, String b) {
         int n=a.length();
           int m=b.length();
           int carray=0;
           String ans="";
           int i=0;
           while(i<n||i<m || carray!=0){
               int x=0;
               if(i<n && a.charAt(n-1-i)=='1'){
                    x=1;
               }
               int y=0;
                if(i<m && b.charAt(m-1-i)=='1'){
                    y=1;
               }
                ans=(x+y+carray)%2+ans;
               carray=(x+y+carray)/2;
               i++;
           }

                   
                   return ans;
    }
}
