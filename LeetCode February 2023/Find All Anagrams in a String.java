class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> list = new ArrayList<Integer>();
        int [] a1 = new int [26];
        int [] a2= new int [26];
        int ind=0,sum=0,t=0;
        for(int i=0;i<p.length();i++){
             a1[p.charAt(i)-'a']++;
             sum+=(p.charAt(i)-'a');
        }
        for(int i=0;i<s.length();i++){
            if(i<p.length()){
                t+=(s.charAt(i)-'a');
                a2[s.charAt(i)-'a']++;
            }
            else{
                t-=(s.charAt(ind)-'a');
                t+=(s.charAt(i)-'a');
                a2[s.charAt(ind)-'a']--;
                a2[s.charAt(i)-'a']++;
                ind++;
            }
            if(i>=p.length()-1&&t==sum){
                if(zero(a1,a2)){
                 list.add(ind);
                }
            }
        }
        return list;
    }
    static boolean zero(int[] a1,int [] a2){
        for(int i=0;i<26;i++){
            if(a1[i]!=a2[i])
            return false;
        }
        return true;
    }
}
