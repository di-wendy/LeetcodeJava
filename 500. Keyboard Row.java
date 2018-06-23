class Solution {
    public String[] findWords(String[] words) {
        String[] keys = new String[]{"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++){
            for (char c : keys[i].toCharArray()){
                map.put(c, i);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String s : words){
            if (s.length() <= 1) {ans.add(s); continue;} //KEY
            int cur = map.get(Character.toUpperCase(s.charAt(0)));
            for (int i = 1; i < s.length(); i++){
                if (map.get(Character.toUpperCase(s.charAt(i))) != cur) break;
                if (i == s.length() - 1) ans.add(s);
            }
        }
        String[] output = new String[ans.size()];
        for (int i = 0; i < output.length; i++){
            output[i] = ans.get(i);
        }
        return output;
    }
}
