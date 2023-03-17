class Trie {
    public TrieNode root;
    
    public class TrieNode{
        TrieNode [] arr;
        boolean end;
        TrieNode(){
           arr = new TrieNode[26];
            this.end = false;
        }
        
    }
    
    Trie(){
        this.root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode curr = root;
        int c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i)-'a';
            if(curr.arr[c]==null){
                curr.arr[c] = new TrieNode();
            }
            curr = curr.arr[c];
        }
        curr.end = true;
        
    }
    
    public boolean search(String s) {
        TrieNode curr = root;
        int c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i)-'a';
            if(curr.arr[c]==null){
                return false;
            }
            curr = curr.arr[c];
        }
        return curr.end;
    }
    
    public boolean startsWith(String s) {
        TrieNode curr = root;
        int c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i)-'a';
            if(curr.arr[c]==null){
                return false;
            }
            curr = curr.arr[c];
        }
        return true;
    }
}
