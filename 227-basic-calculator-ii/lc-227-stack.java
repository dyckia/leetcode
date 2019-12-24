// keep adding cur char to num until a non-digit char is found
// use stack to mimic the operation order
// for * and /, pop previous number and compute immediately
// for + and -, push number to stack and do the computation in the end

class Solution {
    public int calculate(String s) {
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (c == ' ') continue;
                
                int num = Integer.valueOf(sb.toString());
                // clear sb
                sb.setLength(0);
                if (c == '+') {
                    stack.push(num);
                } else if (c == '-') {
                    // push negative num
                    stack.push(-num);
                } else if (c == '*') {
                    // if we encounter '*' or '/', there must be a preceding number
                    // stack is not empty
                    stack.push(stack.pop() * num);
                } else if (c == '/') {
                    stack.push(stack.pop() / num);
                }
            }
        }
        
        // last number
        int res = Integer.valueOf(sb.toString());
        // all remaining operations are plus operations
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}