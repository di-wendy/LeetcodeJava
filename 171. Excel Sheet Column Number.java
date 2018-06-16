class Solution {
    public int titleToNumber(String s) {
        int total = 0;
        for (char c : s.toCharArray()){
            total = total * 26 + (c - 'A' + 1);
        }
        return total;
    }
}
