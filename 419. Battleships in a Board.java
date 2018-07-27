class Solution {
    public int countBattleships(char[][] b) {
        int count = 0;
        if (b.length == 0 || b[0].length == 0) return count;
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < b[0].length; j++){
                if (b[i][j] == 'X'){
                    if ((i - 1 < 0 || b[i - 1][j] != 'X') && (j - 1 < 0 || b[i][j - 1] != 'X')){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
