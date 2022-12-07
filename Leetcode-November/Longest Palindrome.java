class Solution {
    public int longestPalindrome(String s) {
    if(s == "" || s.length() == 0) return 0;
    Set<Character> m = new HashSet<>();
    
    int count =0;
    for(int i=0; i<s.length(); i++){
        if(m.contains(s.charAt(i))){
            m.remove(s.charAt(i));
            count += 2;
        }else{
            m.add(s.charAt(i));
        }
    }
    
     if(m.isEmpty()) 
            return count;

     return count + 1;
    }
}
