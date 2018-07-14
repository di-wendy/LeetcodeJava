class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> name = new HashMap<>();
        for (List<String> a : accounts){
            if (a.size() > 1) name.put(a.get(1), a.get(0));
        }
        Map<String, String> map = new HashMap<>();
        for (List<String> a : accounts){
            //if (a.size() > 1) map.put(a.get(1), a.get(1));
            for (int i = 1; i < a.size(); i++){
                if (map.containsKey(a.get(i))){
                    map.put(findfather(a.get(1),map), findfather(a.get(i), map));
                }
                else map.put(a.get(i), a.get(1));
            }
        }
        //Put into list
        Map<String, TreeSet<String>> ans = new HashMap<>();
        for (String s : map.keySet()){
            String father = findfather(s, map);
            ans.putIfAbsent(father, new TreeSet());
            ans.get(father).add(s);
        }
        //Transfer
        List<List<String>> output = new ArrayList<>();
        for (String s : ans.keySet()){
            output.add(new ArrayList<String>());
            output.get(output.size() - 1).add(name.get(s));
            for (String st : ans.get(s)){
                output.get(output.size() - 1).add(st);
            }
        }
        return output;
    }
    
    public String findfather(String s, Map<String, String> map){
        if (map.get(s).equals(s)) return s;
        return findfather(map.get(s), map);
    }
}
