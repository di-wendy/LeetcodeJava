class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        long sum = 0;
        int count = 0;
        map.put((long)0, 1); //Key
        for (int n : nums){
            sum += n;
            long lowBound = sum - upper;
            long upperBound = sum - lower;
            Map<Long, Integer> cur = map.subMap(lowBound, true, upperBound, true);
            for (Long num : cur.keySet()){
                count += cur.get(num);
            }
            if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return count;
    }
}
