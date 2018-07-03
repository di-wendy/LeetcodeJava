class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if (j == nums.length - 1 || nums[j + 1] != nums[j] + 1){
                ans.add(convertRange(nums[i], nums[j]));
                i = j + 1;
            }
            j++;
        }
        return ans;
    }
    
    public String convertRange(int i, int j){
        if (i == j) return Integer.toString(i);
        return Integer.toString(i) + "->" + Integer.toString(j);
    }
}
