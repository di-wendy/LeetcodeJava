class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        //Keep a non-increasing stack
        for (int i = 0; i < temperatures.length; i++){
            if (st.isEmpty() || temperatures[i] <= temperatures[st.peek()]) st.push(i);
            else{
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                    int index = st.pop();
                    ans[index] = (i - index);
                }
                st.push(i);
            }
        }
        return ans;
    }
}
