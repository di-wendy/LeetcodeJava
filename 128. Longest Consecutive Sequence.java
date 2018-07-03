class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        //Store the longest consecutive sequence
        for (int n : nums){
            if (map.containsKey(n)) continue;
            int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
            int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
            int sum = left + right + 1;
            ans = Math.max(ans, sum);
            map.put(n, sum);
            if (left != 0) map.put(n - left, sum);
            if (right != 0) map.put(n + right, sum);
        }
       
        return ans;
    }
}
