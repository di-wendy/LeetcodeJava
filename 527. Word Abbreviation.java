public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        
        String[] store = new String[dict.size()];
        int[] prefix = new int[dict.size()];
        
        for(int i = 0; i < store.length; i++){
            store[i] = convert(dict.get(i),1);
            prefix[i] = 1;
        }
        
        for(int i = 0; i < store.length; i++){
            while(true){
                Set<Integer> set = new HashSet<>();
                for(int j = i + 1; j < store.length; j++){
                    if(store[j].equals(store[i]))
                        set.add(j);
                }
                if(set.size() == 0) break;
                set.add(i);
                for(int n:set){
                    store[n] = convert(dict.get(n), ++prefix[n]);
                }
            }
        }
        
        return Arrays.asList(store);
    }
    
    public String convert(String s, int index){
        if(index >= s.length() - 2) return s;
        return s.substring(0,index) + (s.length() - index - 1) + s.substring(s.length() - 1);
    }
}
