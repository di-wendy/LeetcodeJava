class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(q1.size() != 0){
            while(q1.size() > 1){
                int temp = q1.poll();
                q2.offer(temp);
            }
            int ans = q1.poll();
            q1 = q2;
            q2 = new LinkedList<Integer>();
            return ans;
        }
        return 0;
    }
    
    /** Get the top element. */
    public int top() {
        if(q1.size() != 0){
            while(q1.size() > 1){
                int temp = q1.poll();
                q2.offer(temp);
            }
            int ans = q1.poll();
            q2.offer(ans);
            q1 = q2;
            q2 = new LinkedList<Integer>();
            return ans;
        }
        return 0;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
