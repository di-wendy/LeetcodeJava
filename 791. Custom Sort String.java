class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) map.put(S.charAt(i), i);
        char[] l = T.toCharArray();
        Character[] letters = new Character[l.length];
        for (int i = 0; i < l.length; i++) letters[i] = Character.valueOf(l[i]);
        
        Arrays.sort(letters, new Comparator<Character>(){
            @Override
            public int compare(Character a, Character b){
                if (map.containsKey(a)){
                    return map.containsKey(b) ? ((map.get(a) < map.get(b)) ? -1 : 1):-1;
                } else {
                    return map.containsKey(b) ? 1 : (a.compareTo(b));
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : letters) sb.append(c);
        return sb.toString();
    }
}
