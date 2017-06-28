public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new LinkedList<String>();
        
        if(nums.length < 1) return ans;
        
        int i = 0, j = 0;
        int mark = nums[i];
        
        while(j < nums.length){
            if(mark == nums[j]){
                if(i == nums.length - 1){
                    ans.add(Integer.toString(nums[i]));
                    break;
                }
                else if(j == nums.length - 1){
                    ans.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j]));
                    break;
                }
                else{
                    mark ++;
                    j ++;
                }
            }
            else{
                if(i == j - 1) {ans.add(Integer.toString(nums[j - 1]));} //Single
                else {ans.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j-1]));} //String
                mark = nums[j];
                i = j;
                }
            }
            
            return ans;
        }
        
    }