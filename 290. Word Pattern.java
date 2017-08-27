class Solution {
    public boolean wordPattern(String pattern, String str) {
        Set<String> set = new HashSet<String>();
        Map<Character,String> mp = new HashMap<>();
        
        char[] input = pattern.toCharArray();
        String[] s = str.split(" ");
        
        if (input.length != s.length){
            return false;
        }
        
        for (int i = 0; i < input.length; i++){
            if(!mp.containsKey(input[i])){
                if (set.contains(s[i])){
                    //System.out.print("*1*");
                    return false;
                }
                mp.put(input[i],s[i]);
                set.add(s[i]);
            }
            else{
                if (!mp.get(input[i]).equals(s[i])){
                    return false;
                }
            }
        }
        
        return true;
    }
}
