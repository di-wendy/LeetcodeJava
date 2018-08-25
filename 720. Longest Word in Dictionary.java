class Node{
    Node[] children;
    boolean end;
    public Node(){
        this.children = new Node[26];
        end = false;
    }
}

public class Solution {
    public String longestWord(String[] words) {
        Node root = new Node();
        String ans = "";
        //Build Trie
        for (String s : words){
            Node point = root;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (point.children[c - 'a'] == null){
                    point.children[c - 'a'] = new Node();
                }
                point = point.children[c - 'a'];
                if (i == s.length() - 1) point.end = true;
            }
        }
        
        for (String s : words){
            Node point = root;
            boolean build = true;
            for (char c : s.toCharArray()){
                if (!point.children[c - 'a'].end){
                    build = false;
                    break;
                }
                point = point.children[c - 'a'];
            }
            if (build && s.length() >= ans.length()) {
                if (s.length() > ans.length()) ans = s;
                else if (ans.compareTo(s) > 0) ans = s; 
            }
        }
        return ans;
    }
}
