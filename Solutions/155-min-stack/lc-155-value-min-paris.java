class MinStack {
    // store the current min value when pushing a new number
    // first element is the number, second element is the min value at that state
    Deque<int[]> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack =  new ArrayDeque<>();
    }
    
    public void push(int x) {
        int minValue;
        if (stack.isEmpty()) minValue = x;
        else minValue = Math.min(x, getMin());
        stack.push(new int[]{x, minValue});
        return;
    }
    
    public void pop() {
        stack.pop();
        return;
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/*
Time: 1

Space: n
*/