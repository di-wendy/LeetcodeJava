public class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        int ans = 0;
        for(int n: nums){
            set.add(n);
        }
        
        for(int n : nums){
            int pre = n - 1;
            int next = n + 1;
            
            while(set.contains(pre)){
                set.remove(pre + 1);
                set.add(pre);
                pre --;
            }
            
            while(set.contains(next)){
                set.remove(next - 1);
                set.add(next);
                next ++;
            }
            
            ans = Math.max(ans, next - pre - 1);
        }
        
        return ans;
    }
}
