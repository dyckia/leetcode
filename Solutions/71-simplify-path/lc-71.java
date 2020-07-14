class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<String>();
        String[] components = path.split("/");
        
        for (String component : components) {
            // empty string or "."
            if (component.isEmpty() || component.equals(".")) continue;
            if (component.equals("..")) {
                // .. pop last element if not empty
                // deque.removeFirst();
                if (!deque.isEmpty()) deque.pop();
            } else {
                // deque.addFirst(component);
                deque.push(component);
            }
            
        }
        
        // re-join each component
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.removeLast());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

/*
Time: n

Space: n
*/