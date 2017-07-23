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
