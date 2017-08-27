class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for(String path : paths) {
            String[] tokens = path.split(" ");
            for(int i = 1; i < tokens.length; i++) {
                String file = tokens[i].substring(0, tokens[i].indexOf('('));
                String content = tokens[i].substring(tokens[i].indexOf('(') + 1,tokens[i].indexOf(')'));
                if (!mp.containsKey(content)){
                    mp.put(content, new ArrayList<String>());
                }
                mp.get(content).add(tokens[0] + "/" + file);
            }
        }
        
        for (String content: mp.keySet()){
            if(mp.get(content).size() <= 1){
                continue;
            }
            else{
                ans.add(mp.get(content));
            }
        }
        return ans;
    }
}
