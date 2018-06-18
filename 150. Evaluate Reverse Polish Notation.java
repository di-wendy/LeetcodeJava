class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens){
            if (s.length() == 1 && !Character.isDigit(s.charAt(0))){
                int b = st.pop(); //key
                int a = st.pop();
                int val = 0;
                if (s.charAt(0) == '+'){
                    val = a + b;
                } else if (s.charAt(0) == '-'){
                    val = a - b;
                } else if (s.charAt(0) == '*'){
                    val = a * b;
                } else {
                    val = a / b;
                }
                st.push(val);
            } else {
                st.push(Integer.valueOf(s));
            }
        }
        return (st.size() == 0) ? 0 : st.pop();
    }
}
