class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int total = 0;
        int line = 0; //record the line number
        for (char c : S.toCharArray()){
            if (total + widths[c - 'a'] > 100){
                line++;
                total = widths[c - 'a'];
            } else {
                total += widths[c - 'a'];
            }
        }
        return new int[]{line + 1, total};
    }
}
