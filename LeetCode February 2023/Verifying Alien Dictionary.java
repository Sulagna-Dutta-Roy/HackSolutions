class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (!word(words[i], words[i+1], order)) {
                return false;
            }
        }
        return true;
    }
    private boolean word(String word1, String word2, String order) {
        boolean word1Short = word1.length() <= word2.length();
        int wordLen = word1Short ? word1.length() : word2.length();
        for (int i = 0; i < wordLen; i++) {
            int index1 = order.indexOf(word1.charAt(i));
            int index2 = order.indexOf(word2.charAt(i));
            if (index1 < index2) {
                return true;
            } else if (index1 > index2) {
                return false;
            }
        }
        return word1Short;
    }
}
