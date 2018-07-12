class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0) return ans;
        while (rowIndex > 0){
            ans.add(1);
            for (int i = ans.size() - 2; i >= 1; i--){
                int temp = ans.get(i);
                ans.set(i, temp + ans.get(i - 1));
            }
            rowIndex--;
        }
        return ans;
    }
}
