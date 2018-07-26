class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--){
            if (!map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), i);
            }
        }
        int i = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < S.length()){
            int start = i;
            int mark = map.get(S.charAt(i));
            while (i < mark){
                mark = Math.max(mark, map.get(S.charAt(i)));
                i++;
            }
            ans.add(mark - start + 1);
            i++;
        }
        return ans;
    }
}
