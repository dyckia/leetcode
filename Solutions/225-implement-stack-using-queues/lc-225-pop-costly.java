class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int val = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    /** Get the top element. */
    public int top() {
        int val = pop();
        q1.offer(val);
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
