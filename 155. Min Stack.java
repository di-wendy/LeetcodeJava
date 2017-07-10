public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack <Integer> st;
    
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack <Integer>();
    }
    
    public void push(int x) {
        if(x<=min){ //if x=2, min = 3
            st.push(min);
            min = x; //record the second biggest
        }
        st.push(x);
    }
    
    public void pop() {
        if(st.pop()==min) min = st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 //Two Stacks
 public class MinStack {
    
    Stack<Integer> st;
    Stack<Integer> minst;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer>();
        minst = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if(minst.size() == 0){
            minst.push(x);
            return;
        }
        int min = Math.min(minst.peek(),x);
        minst.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}