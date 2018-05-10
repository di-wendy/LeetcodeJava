public class WordDictionary {
    
    public class TrieNode {
        private TrieNode[] children;
        private String item;
        public TrieNode(){
            children = new TrieNode[26];
            item = "";
        }
    }
    
    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");   
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

//HashMap
class TrieNode{
    Map<Character, TrieNode> children;
    boolean hasWord;
    public TrieNode(Map<Character, TrieNode> children, boolean hasWord){
        this.children = children;
        this.hasWord = hasWord;
    }
}

public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(new HashMap<Character, TrieNode>(), false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = root.children;
        for (char c : word.toCharArray()){
            if (curChildren.containsKey(c)){
                cur = curChildren.get(c);
                curChildren = cur.children;
            }
            else{
                curChildren.put(c, new TrieNode(new HashMap<Character, TrieNode>(), false));
                cur = curChildren.get(c);
                curChildren = cur.children;
            }
        }
        cur.hasWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        return searchWord(word, 0, cur);
    }

    public boolean searchWord(String word, int index, TrieNode cur){
        if (index == word.length()){
            return (cur.hasWord);
        }

        char c = word.charAt(index);

        if (cur.children.containsKey(c)){
            return searchWord(word, index + 1, cur.children.get(c));
        }

        if (c == '.'){
            for (Map.Entry<Character, TrieNode> child : cur.children.entrySet()){
                if (index == word.length() - 1 && child.getValue().hasWord){
                    return true;
                }
                if (searchWord(word, index+1, child.getValue())){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */