class Node{
    Node[] children;
    boolean end;
    String word;
    public Node(){
        this.children = new Node[26];
        end = false;
        word = "";
    }
}

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node();
        
        //Build Trie
        for (String s : dict){
            Node point = root;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (point.children[c - 'a'] == null){
                    point.children[c - 'a'] = new Node();
                }
                point = point.children[c - 'a'];
                if (i == s.length() - 1) {
                    point.end = true;
                    point.word = s;
                }
            }
        }
        //Build answer
        String[] ans = sentence.split(" ");
        for (int i = 0; i < ans.length; i++){
            Node point = root;
            for (char c : ans[i].toCharArray()){
                if (point.children[c - 'a'] == null){
                    break;
                } else {
                    if (point.children[c - 'a'].end) {
                        ans[i] = point.children[c - 'a'].word;
                        break;
                    }
                    point = point.children[c - 'a'];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++){
            sb.append(ans[i]);
            if (i != ans.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
//Search
public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        
        int longest = 0;
        HashSet<String> hs = new HashSet<String>();
        
        for(String a: dict){
            hs.add(a);
            longest = Math.max(a.length(),longest);
        }
        
        String[] store = sentence.split(" ");
        
        for(int k = 0; k < store.length; k++){
            int i = 1;
            int j = Math.min(i + longest, store[k].length());
            while(i < j){
                if(hs.contains(store[k].substring(0,i))){
                    store[k] = store[k].substring(0,i);
                    break;
                }
                i++;
            }
        }
        
        String ans = "";
        
        for(int k = 0; k < store.length - 1; k++){
            ans += (store[k] + " ");
        }
        
        ans += store[store.length - 1];
        
        
        return ans;
    }
}
