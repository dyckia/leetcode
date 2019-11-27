class MyStack {
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = q.size() - 1; i > 0; i--) {
            q.offer(q.poll());
        }
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        int val = pop();
        q.offer(val);
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
