class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int diff = 26;
        char ans = target;
        
        for (char c : letters){
            if (c == target) continue;
            int cur = (c - target < 0) ? c - target + 26 : c - target;
            if ( cur < diff){
                ans = c;
                diff = cur;
            }
        }
        return ans;
    }
}
