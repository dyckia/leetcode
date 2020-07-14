class MinStack {
    // one stack to store the value
    // one stack to store the min value at that current state
    // push min value only when the cur_minValue is less than or equal to minValue
    // to avoid pushing same min mutiple times, we can use {min, count} pair instead
    Deque<Integer> values;
    Deque<int[]> mins;
    
    /** initialize your data structure here. */
    public MinStack() {
        values = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (values.isEmpty() || x < mins.peek()[0])
            mins.push(new int[] {x, 1});
        else if (x == mins.peek()[0])
            mins.peek()[1]++;
        values.push(x);
        return;
    }
    
    public void pop() {
        int value = values.pop();
        if (value == mins.peek()[0]) {
            if (mins.peek()[1] == 1)
                mins.pop();
            else 
                mins.peek()[1]--;
        }
        return;
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek()[0];
    }
}

/*
Time: 1

Space: n
*/