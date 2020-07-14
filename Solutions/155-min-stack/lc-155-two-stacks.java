class MinStack {
    // one stack to store the value
    // one stack to store the min value at that current state
    // push min value only when the cur_minValue is less than or equal to minValue
    Deque<Integer> values;
    Deque<Integer> mins;
    
    /** initialize your data structure here. */
    public MinStack() {
        values = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (values.isEmpty() || x <= mins.peek())
            mins.push(x);
        values.push(x);
        return;
    }
    
    public void pop() {
        int value = values.pop();
        if (value == mins.peek())
            mins.pop();
        return;
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/*
Time: 1

Space: n
*/