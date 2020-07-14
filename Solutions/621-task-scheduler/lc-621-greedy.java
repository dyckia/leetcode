class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Since two same tasks have to be n intervals apart
        // the total length depends on the numbers of the most frequent tasks
        
        // Case A
        // if the number of kinds of tasks is less than n
        // we must add intervals 
        // A 3, B 3, C 1, n = 4
        // A B C _ _ | A B _ _ _ | AB |
        // the length would be (Freq(A) - 1) * (n + 1) + Num(most frequent task kind)
        
        // Case B
        // if the number of kind of tasks is greater than n
        // we don't need to add intervals
        // A 3, B 2, C 2, D 2, n = 2
        // A B C | A B C | A | D D 
        // instead of arranging like this
        // we can always put those extra tasks inside other circles
        // A B C D | A B C D | A
        // in this arrangement, we can complete all tasks without adding idles
        // the length would be tasks.length
        
        // so the min intervals would be either be A or B, whichever is the greater
        
        int[] count = new int[26];
        // we only concern about the count of most frequent tasks 
        // and the number of kinds of most frequent tasks
        
        int maxCount = 0,
            maxKinds = 0;
        
        for (char task : tasks) {
            int curTaskCount = ++count[task - 'A'];
            
            if (curTaskCount == maxCount) {
                // cur task has same count as max count
                maxKinds++;
            } else if (curTaskCount > maxCount) {
                // cur task is the most frequent task
                maxCount = curTaskCount;
                maxKinds = 1;
            }
        }
        
        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxKinds);
    }
}