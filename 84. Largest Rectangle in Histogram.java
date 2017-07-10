public class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int len = heights.length;
        int ans = 0;
        
        Stack<Integer> st = new Stack<Integer>(); //to store index
        
        for(int i = 0; i <= len; i++){
            
            int h = (i == len)?0:heights[i];
            if(st.empty() || h >= heights[st.peek()]){
                st.push(i);
            }
            else{
                int cur = st.pop();
                if(st.empty()){
                    ans = Math.max(ans, heights[cur]*i);
                }
                else{
                    ans = Math.max(ans, heights[cur]*(i - 1 - st.peek()));
                }
            i--;
            }
        }
        
        return ans;
    }
}