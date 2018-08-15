class Solution {
    public int kEmptySlots(int[] f, int k) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < f.length; i++) pos.put(i + 1, f[i]); //position is f[i]
        
        for (int i = 1; i <= f.length; i++){
            int cur = pos.get(i);
            tmap.put(cur, 0);
            if (tmap.lowerKey(cur) != null 
                && (cur - tmap.lowerKey(cur) - 1 == k)) {
                return i;
            }
            if (tmap.higherKey(cur) != null 
                && (tmap.higherKey(cur) - cur - 1 == k)) {
                return i;
            }
        }
        return -1;
    }
}
