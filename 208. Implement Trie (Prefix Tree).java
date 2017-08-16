public class Trie {
    
    public class TrieNode{
        private TrieNode[] children;
        public boolean EndNode;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.EndNode = false;
        }

        public void insert(String word, int index){
            if(index == word.length()){
                EndNode = true;
                return;
            }
            int temp = word.charAt(index) - 'a';
            if(children[temp] == null)
                children[temp] = new TrieNode();
            children[temp].insert(word, index + 1);
        }

        public TrieNode find(String word, int index){
            if(index == word.length())
                return this;
            int temp = word.charAt(index) - 'a';
            if(children[temp] == null)
                return null;
            return children[temp].find(word, index + 1);
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root.find(word, 0);
        return (temp != null && temp.EndNode);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root.find(prefix, 0);
        return (temp != null);
    }
}
