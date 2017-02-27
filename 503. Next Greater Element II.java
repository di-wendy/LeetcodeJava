public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if (nums == null) return null;
        if (nums.length ==0) return nums;
        if (nums.length <2){
            nums[0] = -1;
            return nums;}
        
        int[] ans = new int[nums.length];
        
        Stack <Integer> st = new Stack <Integer>();
        
        int max = nums[0];
        int mark = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
                mark = i;
            }
        }
        st.push(nums[mark]);
        ans[mark] = -1;
        
        for(int i=nums.length+mark-1; i>mark; i--){
            
            if(nums[i%nums.length]==max){
                ans[i%nums.length] = -1;
                st.push(nums[i%nums.length]);
                continue;
            }
            while(nums[i%nums.length]>=st.peek() && nums[i%nums.length]!=max){
                st.pop();
            }
            ans[i%nums.length] = st.peek();
            st.push(nums[i%nums.length]);
        }
        
        return ans;
    }
}
