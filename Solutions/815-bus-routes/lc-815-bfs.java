class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        
        // create a stop -> buses map
        Map<Integer, List<Integer>> busMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> buses = busMap.getOrDefault(routes[i][j], new ArrayList<Integer>());
                buses.add(i);
                busMap.put(routes[i][j], buses);
            }
        }
        
        Deque<Integer> stopQueue = new ArrayDeque<>();
        stopQueue.offer(S);
        boolean[] rided = new boolean[routes.length];
        int rideCount = 0;
        
        // BFS from start stop
        while (!stopQueue.isEmpty()) {
            rideCount++;
            for (int i = stopQueue.size(); i > 0; i--) {
                int curStop = stopQueue.poll();
                // buses we can get onto from current stop
                List<Integer> buses = busMap.get(curStop);
                for (int bus : buses) {
                    if (!rided[bus]) {
                        rided[bus] = true;
                        for (int stop : routes[bus]) {
                            if (stop == T) return rideCount;
                            stopQueue.offer(stop);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}

/*
Time: O(m * n)
For each stop, we need to ride every bus

Space: O(m * n)
For storing the busMap
*/