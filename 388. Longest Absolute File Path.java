class Solution {
    public int lengthLongestPath(String s) {
        int ans = 0;
        String[] files = s.split("\n");
        int[] length = new int[files.length];
        for (String t : files){
            int level = t.lastIndexOf("\t");
            int cur = t.substring(level + 1, t.length()).length();
            length[level + 1] = (level + 1 == 0) ? cur + 1 : length[level] + cur + 1;
            if (t.indexOf('.')!= -1){
                ans = Math.max(length[level + 1] -1, ans);
            }
        }
        return ans;
    }
}
