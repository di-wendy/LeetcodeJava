class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //Decode the string to make it as key of the hashmap
        //convert the word, starting with a
        Map<String, List<String>> mp = new HashMap<>();
        
        for (String s : strings){
            String temp = convert(s);
            if (!mp.containsKey(temp)){
                mp.put(temp, new ArrayList<>());
            }
            mp.get(temp).add(s);
        }
        return new ArrayList<>(mp.values());
    }
    
    public String convert(String s){
        if (s.length() == 0){
            return "";
        }
        char[] chars = s.toCharArray();
        int shift = s.charAt(0) - 'a';
        for (int i = 0; i < s.length(); i++){
            chars[i] = (char)((chars[i] - shift) >= 'a' ? 
                (chars[i] - shift) : (chars[i] - shift + 26));
        }
        return new String(chars);
    }
}
