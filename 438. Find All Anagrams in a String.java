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

//O(24n)
