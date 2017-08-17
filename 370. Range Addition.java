public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            ans[start] += val;
            if(end + 1 < length) ans[end + 1] -= val;
        }
        
        int sum = 0;
        for (int i = 0; i < length; i++){
            sum += ans[i];
            ans[i] = sum;
        }
        return ans;
    }
}
