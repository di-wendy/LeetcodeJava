public class Solution {
    public int[] constructRectangle(int area) {
        
        int bound = (int)Math.sqrt(area);
        
        while(area % bound != 0){
            bound --;
        }

        int[] ans = new int[2];
        ans[0] = area/bound;
        ans[1] = bound;
        return ans;
    }
}
