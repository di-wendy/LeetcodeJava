class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++){
            int j = i;
            while (j > 0){
                if (j % 10 == 0) break;
                if (i% (j % 10) != 0) break;
                j /= 10;
            }
            if (j == 0) ans.add(i);
        }
        return ans;
    }
}
