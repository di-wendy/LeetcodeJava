class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        //For a certain nut
        //total distance = dis(s, n) + dis(n, t) for the min Dis(s, n)
        
        //Find the cloest nuts to squirrel
        int dis = Integer.MIN_VALUE;
        int treeDis = 0;
        for (int[] nut : nuts){
            treeDis = getDis(tree, nut);
            if (treeDis - getDis(squirrel, nut) > dis){
                dis = treeDis - getDis(squirrel, nut);
            }
        }
        int ans = 0;
        //For other nuts: dis = dis(n, t) * 2;
        for (int[] nut : nuts){
            ans += getDis(tree, nut)*2;
        }
        return ans - dis; //KEY
    }
    
    public int getDis(int[] s, int[] n){
        int x = Math.abs(s[0] - n[0]);
        int y = Math.abs(s[1] - n[1]);
        return x + y;
    }
}
