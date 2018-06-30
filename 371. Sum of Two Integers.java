class Solution {
    public int getSum(int a, int b) {
        int ans = a;
        int temp = b;
        while (temp != 0){
            int pre = ans;
            ans = (ans ^ temp);
            temp = (pre & temp)<<1;
        }
        return ans;
    }
}
