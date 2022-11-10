class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length()-1;
        int count = 0;
        while(s.charAt(n) == ' ') {
            n--;
        }
        while(s.charAt(n) != ' ') {
            count++;
            n--;
            if(n < 0) {
                return count;
            }
        }
        return count;
    }
}
