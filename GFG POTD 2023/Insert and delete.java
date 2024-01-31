static void insert(TrieNode root, String key) 
{
    // Your code here
    TrieNode curr = root;
    for(int level=0; level<key.length(); level++){
        int idx = key.charAt(level)-'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new TrieNode();
        }
        curr = curr.children[idx];
    }
    curr.isEndOfWord = true;
}

//Code By Abhishek Jha
static boolean search(TrieNode root, String key)
{
    
    TrieNode curr = root;
    for(int level=0; level<key.length(); level++){
        int idx = key.charAt(level)-'a';
        if(curr.children[idx] == null){
            return false;
        }
        curr = curr.children[idx];
    }
    return curr.isEndOfWord == true;
}

