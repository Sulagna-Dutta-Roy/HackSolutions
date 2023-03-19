class WordDictionary {
    private WordDictionary[] child;
    boolean word;
    public WordDictionary() {
        child = new WordDictionary[26];
        word = false;
    }
    
    public void addWord(String word) {
        WordDictionary curr = this;
        for(char c: word.toCharArray()){
            if(curr.child[c - 'a'] == null)
                curr.child[c - 'a'] = new WordDictionary();
            curr = curr.child[c - 'a'];
        }
        curr.word = true;
    }
    
    public boolean search(String word) {
        WordDictionary curr = this;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.'){
                for(WordDictionary ch: curr.child)
                    if(ch != null && ch.search(word.substring(i+1))) return true;
                return false;
            }
            if(curr.child[c - 'a'] == null) return false;
            curr = curr.child[c - 'a'];
        }
        return curr != null && curr.word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
