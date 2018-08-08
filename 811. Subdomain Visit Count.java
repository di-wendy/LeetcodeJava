class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains){
            int num = Integer.valueOf(s.substring(0, s.indexOf(" ")));
            s = s.substring(s.indexOf(" ") + 1); //discuss.leetcode.com
            int i = 0;
            while (true){
                String cur = s.substring(i);
                map.put(cur, map.getOrDefault(cur, 0) + num);
                if (s.indexOf('.', i + 1) == -1) break;
                else i = s.indexOf('.', i + 1) + 1;
            }
        }
        List<String> output = new LinkedList<>();
        for (String key : map.keySet()){
            String cur = Integer.toString(map.get(key));
            cur += " ";
            cur += key;
            output.add(cur);
        }
        return output;
    }
}
