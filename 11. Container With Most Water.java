//35%
public class Solution {
    public int maxArea(int[] height) {
        
        int p1 = 0;
        int p2 = height.length-1;
        int ans = (height.length-1)*Math.min(height[p1],height[p2]);
        
        while(p1<p2){
            if(height[p2]>height[p1]){
                p1++;
            }
            else p2--;
            ans = Math.max(ans,(p2-p1)*Math.min(height[p1],height[p2]));
        }
        
        return ans;
    }
}
