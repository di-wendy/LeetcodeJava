class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] dis = new int[S.length()];
        int pos = -S.length();
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == C){
                pos = i;
            } else {
                dis[i] = i - pos;
            }
        }
        for (int i = pos; i >= 0; i--){
            if (S.charAt(i) == C){
                pos = i;
            } else {
                dis[i] = Math.min(dis[i], pos - i);
            }
        }
        return dis;
    }
}
