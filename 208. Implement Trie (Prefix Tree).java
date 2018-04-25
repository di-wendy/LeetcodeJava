class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;
}


public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        
        for (char c: word.toCharArray()){
            if (!curChildren.containsKey(c)){
                curChildren.put(c, new TrieNode());
            }
            cur = curChildren.get(c);
            curChildren = cur.children;
        }
        cur.hasWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode finalNode = searchNode(word);
        return (finalNode != null && finalNode.hasWord);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return (searchNode(prefix) != null);
    }
    
    public TrieNode searchNode(String word){
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        for (char c : word.toCharArray()){
            if (!curChildren.containsKey(c)){
                return null;
            }
            cur = curChildren.get(c);
            curChildren = cur.children;
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
