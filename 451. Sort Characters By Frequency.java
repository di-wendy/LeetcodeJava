public class Solution {
    public String frequencySort(String s) {
        //Sort by char frequency
        
        char[] chars  = s.toCharArray();
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        
        for(char a: chars){
            if(!hm.containsKey(a)){
                hm.put(a,1);
            }
            else{
                hm.put(a,hm.get(a) + 1);
            }
        }
        
        List<Character>[] store = new List[s.length() + 1];
        
        for(char value:hm.keySet()){
            int temp = hm.get(value);
            if(store[temp] == null){
                store[temp] = new ArrayList<Character>();
            }
            store[temp].add(value);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = s.length(); i > 0; i--){
            if(store[i] != null){
                for(char x:store[i]){
                    for(int j = 0; j < i; j++){
                        sb.append(x);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}