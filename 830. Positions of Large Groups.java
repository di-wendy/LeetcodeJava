class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        //Map<Character, List<int[]>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        char c = ' ';
        while (j <= S.length()){
            if (j == S.length() || S.charAt(j) != c){
                if ((j - i) >= 3){
                    Integer[] temp = new Integer[]{i, j - 1};
                    ans.add(Arrays.asList(temp));
                }
                if (j < S.length()) c = S.charAt(j);
                i = j;
            }
            j++;
        }
        
        return ans;
    }
}
