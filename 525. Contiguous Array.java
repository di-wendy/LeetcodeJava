class Solution {
    public int findMaxLength(int[] nums) {
        //Store diff = zeros - ones
        Map<Integer, Integer> diff = new HashMap<>();
        
        int countZero = 0;
        int countOne = 0;
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) countZero++;
            else countOne++;
            int cur = countZero - countOne;
            if (cur == 0) ans = i + 1;
            else{
                if (diff.containsKey(cur)){ 
                    //Key, same(zeros - ones) value means the middle is balanced
                    ans = Math.max(ans, i - diff.get(cur));
                }
            }
            if (!diff.containsKey(cur)) diff.put(cur, i);
        }
        return ans;
    }
}
