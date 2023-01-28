class Solution {
    public int mostWordsFound(String[] sentences) {
        int words = 0;
        for(String sentence:sentences) {
            words = Math.max(words,(sentence.split(" ")).length);
        
        }   
         return words;
    }
}
