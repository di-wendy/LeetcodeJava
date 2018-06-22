class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int i = 1;
        
        while (i <= c /i){
            set.add(i * i);
            i++;
        }
        for (int n : set){
            if (set.contains(c - n)){
                return true;
            }
        }
        return false;
    }
}
