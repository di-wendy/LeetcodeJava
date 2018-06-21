class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (!left.containsKey(nums[i])) left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i],0) + 1);
            if (count.get(nums[i]) >= max) max = count.get(nums[i]);
        }
        int ans = nums.length;
        for (int n : count.keySet()){
            if (count.get(n) == max) ans = Math.min(ans, right.get(n) - left.get(n) + 1);
        }
        return ans;
    }
}
