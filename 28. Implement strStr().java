class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0) return (needle.length() == 0) ? 0 : -1;
        if (needle.length() == 0) return 0;

        for (int s = 0; s < haystack.length(); s++){
            int p1 = s;
            int p2 = 0;
            while (p1 < haystack.length() && p2 < needle.length() && haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
                if (p2 == needle.length()) return p1 - p2;
            }
        }
        return -1;
    }
}
