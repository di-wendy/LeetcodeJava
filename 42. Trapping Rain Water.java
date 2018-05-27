class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        
        int leftMin = height[0];
        int rightMin = height[height.length - 1];
        int l = 0;
        int r = height.length - 1;
        int total = 0;
        
        while (l <= r) { //l and r are not processed
            if (leftMin < rightMin){
                if (leftMin > height[l]){
                    total += leftMin - height[l];
                } else {
                    leftMin = height[l];
                }
                l++;
            } else {
                if (rightMin > height[r]){
                    total += rightMin - height[r];
                } else {
                    rightMin = height[r];
                }
                r--;
            }
        }
        
        return total;
    }
}
