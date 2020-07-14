class Solution {
    public int leastInterval(char[] tasks, int n) {
        // use array to store the frequency of each char
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        
        PriorityQueue <Integer> queue = new PriorityQueue<> (26, (a1, a2) -> (a2 - a1));
        
        for (int f : freq) {
            if (f != 0) queue.add(f);
        }
        
        int intervals = 0;
                
        while (!queue.isEmpty()) {
            int indexIncycle = 0;
            List<Integer> newFreq = new ArrayList<> ();
            
            while (indexIncycle <= n) {
                // stop if there is no task left
                
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        newFreq.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                
                intervals++;
                indexIncycle++;
                
                if (queue.isEmpty() && newFreq.size() == 0) break;
            }
            
            for (Integer e : newFreq) {
                queue.add(e);
            }
        }
        
        return intervals;
    }
}