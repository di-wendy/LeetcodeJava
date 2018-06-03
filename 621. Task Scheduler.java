class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        //Store Frq in map
        for (char c : tasks){
            map[c - 'A']++;
        }
        
        Arrays.sort(map);
        int ans = 0;
        while (map[25] != 0){
            int i = 0; //tasks in current cycle
            while (i <= n){
                if (map[25] == 0) break;
                if (i <= 25 && map[25 - i] > 0){
                    map[25 - i]--;
                }
                i++;
                ans++;
            }
            Arrays.sort(map);
        }
        
        return ans;
    }
}
