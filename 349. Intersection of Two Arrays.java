class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> hs = new HashSet<Integer>();
        
        for (int num : nums1){
            hs.add(num);
        }
        
        for (int num : nums2){
            if (hs.contains(num)){
                set.add(num);
            }
        }
        int i = 0;
        int[] ans = new int[set.size()];
        
        for(Integer n : set){
            ans[i] = (int)n;
            i ++;
        }
        return ans;
    }
}
