class Solution {
    public String toGoatLatin(String S) {
        Character[] vowel = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>();
        for (char c : vowel) set.add(c);
        
        String[] words = S.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            if (!set.contains(word.charAt(0))) {
                ans.append(word.substring(1) + word.substring(0, 1));
            } else {
                ans.append(word);
            }
            ans.append("ma");
            for (int j = 0; j <= i; j++){
                ans.append("a");
            }
            if (i != words.length - 1) ans.append(" ");
        }
        return ans.toString();
    }
}
