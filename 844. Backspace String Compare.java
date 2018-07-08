class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        while (i >= 0 && j >= 0){
            i = nextChar(S, i);
            j = nextChar(T, j);
            if (i == -1) return j == -1;
            if (j == -1) return i == -1;
            if (S.charAt(i) != T.charAt(j)) return false;
            i -= 1;
            j -= 1;
        }
        if (i >= 0) i = nextChar(S, i);
        if (j >= 0) j = nextChar(T, j);
        return i == -1 && j== -1;
    }
    public int nextChar(String S, int i){
        int counter = 0;
        while (i >= 0){
            if (S.charAt(i) == '#') counter--;
            else counter++;
            if (counter == 1) return i;
            i--;
        }
        return -1;
    }
}
