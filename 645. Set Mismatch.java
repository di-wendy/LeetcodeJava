public class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] store = new int[nums.length + 1];

        int[] ans = new int[2];

        for(int n:nums){
            if(store[n] == 0){
                store[n] += 1;
            }
            else{
                ans[0] = n;
            }
        }

        for(int i = 1; i < store.length; i++){
            if(store[i] == 0){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}
