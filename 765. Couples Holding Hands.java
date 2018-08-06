class Solution {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) map.put(row[i], i);
        for (int i = 0; i < row.length; i+=2){
            int cur = row[i];
            if (cur % 2 == 0){
                if (row[i + 1] == cur + 1) continue;
                ans++;
                swap(row, i + 1, map.get(cur + 1), map);
            } else {
                if (row[i + 1] == cur - 1) continue;
                ans++;
                swap(row, i + 1, map.get(cur - 1), map);
            }
        }
        return ans;
    }
    public void swap(int[] row, int i, int j, Map<Integer, Integer> map){
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
        map.put(row[i], i);
        map.put(row[j], j);
    }
}
