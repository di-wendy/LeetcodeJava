class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        ans.add(Arrays.asList(1));
        while (numRows > 1){
            List<Integer> temp = new ArrayList<>();
            List<Integer> last = ans.get(ans.size() - 1);
            for (int i = 0; i < last.size(); i++){
                if (i == 0) temp.add(1);
                else temp.add(last.get(i) + last.get(i - 1));
            }
            temp.add(1);
            ans.add(temp);
            numRows--;
        }
        return ans;
    }
}
