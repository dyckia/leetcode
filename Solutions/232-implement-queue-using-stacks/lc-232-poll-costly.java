class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
        return;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        for (int i = s1.size(); i > 1; i--) {
            s2.push(s1.pop());
        }
        int val = s1.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        for (int i = s1.size(); i > 1; i--) {
            s2.push(s1.pop());
        }
        int val = s1.pop();
        s2.push(val);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return val;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}