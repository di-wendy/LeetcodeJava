public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> mp = new HashMap<String, List<String>>();
        
        for(String str:strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            if(!mp.containsKey(sorted)){
                mp.put(sorted,new ArrayList<String>());
            }
            mp.get(sorted).add(str);
        }
        
        return new ArrayList<List<String>>(mp.values());
    }
}
