public class Solution {
    public int trap(int[] height) {
        
        if(height.length < 3) return 0;
        
        //Two pointer
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < height.length - 1 && height[left] < height[left + 1]) left++;
        while(right > 0 && height[right] < height[right - 1]) right --;
        
        while(left < right){
            int lmax = height[left];
            int rmax = height[right];
            if(lmax < rmax){
                while(left <= right && height[++left] < lmax){
                    ans += lmax - height[left];
                }
            }
            else{
                while(left <= right && height[--right] < rmax){
                    ans += rmax - height[right];
                }
            }
        }
       
        return ans;
    }
}