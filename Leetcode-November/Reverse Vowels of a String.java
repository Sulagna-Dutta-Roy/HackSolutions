class Solution {
    public String reverseVowels(String s) {
       String vowels = "aeiouAEIOU";
        StringBuilder reverse = new StringBuilder(s);
        int p = 0, q = s.length() - 1;
        while (p < q) {
            int checkP = vowels.indexOf(reverse.charAt(p));
            int checkQ = vowels.indexOf(reverse.charAt(q));
            if (checkP == -1) p++;
            if (checkQ == -1) q--;
            if (checkP != -1 && checkQ != -1) {
                reverse.setCharAt(p, s.charAt(q));
                reverse.setCharAt(q, s.charAt(p));
                p++;
                q--;
            }
        }
        return reverse.toString(); 
    }
}
