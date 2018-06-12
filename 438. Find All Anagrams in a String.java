class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] dic1 = new int[26]; //Store the occurance of each letter
        int[] dic2 = new int[26];
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()){
            dic2[c - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++){
            dic1[s.charAt(i) - 'a']++;
            if (i >= p.length()){
                dic1[s.charAt(i - p.length()) - 'a']--;
            }
            if (i >= p.length() - 1){
                for (int j = 0; j < 26; j++){
                    if (dic1[j] != dic2[j]){
                        break;
                    }
                    if (j == 25){
                        res.add(i - p.length() + 1);
                    }
                }
            }
        }
        return res;
    }
}

//Counter
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (char c : p.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        int size = mp.size();
        for (int i = 0, j = 0; i< s.length(); i++){
            if (mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) size--;
            }
            while (size == 0){
                if (i - j + 1 == p.length()) ans.add(j); //Key
                if (mp.containsKey(s.charAt(j))){
                    mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
                    if (mp.get(s.charAt(j)) > 0) size++;
                }
                j++;
            }
            
        }
        return ans;
    }
}
