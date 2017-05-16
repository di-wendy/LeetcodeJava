public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int p = -1; //POS for word1
        int q = -1; //POS for word2
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && words[i].equals(word2)){
                p = q;
                q = i; 
                //slide two pointer, q is always the front pos when word1 == word2
            }
            else{
                if(words[i].equals(word1)){
                    p = i;
                }
                if(words[i].equals(word2)){
                    q = i;
                }
            }
            if(p!=-1 && q!=-1){
                ans = Math.min(ans,Math.abs(p-q));
            }
        }
        
        //Proof: word1 and word2 are both in the list. 
        //Whenever update p/q, the existing q/p is the nearest one to the left.
        
        return ans;
    }
}