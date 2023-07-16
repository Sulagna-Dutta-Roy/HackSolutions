class Solution {
    public int maxInstance(String s) {
        int[] b=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            v[ch-'a']++;
        }
        return Math.min(Math.min(b[0],b[1]),Math.min(Math.min(b[11]/2,b[14]/2),b[13]));
    }
}
