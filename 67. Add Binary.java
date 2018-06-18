class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0){
            int numA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int numB = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int cur = (carry + numA + numB) % 2;
            carry = (carry + numA + numB)/2;
            ans.append(cur);
        }
        if (carry != 0) ans.append('1');
        return ans.reverse().toString();
    }
}
