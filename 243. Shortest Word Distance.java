
//Di's Solution Theta(n) beat 23%
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        HashSet <String> hs = new HashSet <String>();
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<words.length; i++){
            
            if (words[i].equals(word1) || words[i].equals(word2)){
                
                if (hs.size()== 0) left = i;
                if (hs.size() !=0 && !hs.contains(words[i])) right = i;
                if (hs.size() !=0 && hs.contains(words[i])) left = i;
                hs.add(words[i]);
                
            }
            if (hs.size()==2){
                ans = Math.min(ans,Math.abs(left-right));
                if (words[i].equals(word1)) hs.remove(word2);
                else hs.remove(word1);
                left = i;
            }
        }
        
        return ans;
    }
}

//Two list beat 23%
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        List <Integer> wlist1 = new ArrayList<Integer> ();
        List <Integer> wlist2 = new ArrayList<Integer> ();
        
        int ans = words.length;
        
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)) wlist1.add(i);
            if(words[i].equals(word2)) wlist2.add(i);
        }
        
        int p = 0;
        int q = 0;
        while(p<wlist1.size() && q<wlist2.size()){
            ans = Math.min(ans,Math.abs(wlist1.get(p)-wlist2.get(q)));
            
            if (wlist1.get(p)<wlist2.get(q)) p++;
            else q++;
        }
        
        return ans;
        
    }
}
