class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        // find the smallest k such that
        // sum(celi(p[i] / k)) <= H
        
        // the problem can be turned into a binary search problem 
        // the fastest speed is max(piles), thus we need to search in [1, max]
        int left = 1;
        // int right = findMaxInArray(piles);
        int right = 1000000000;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = calTime(piles, mid);
            if (time > H) {
                // we need to speed up
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // skip the scan to improve speed
    private int findMaxInArray(int[] arr) {
        int max = 0;
        for (int element : arr) {
            max = Math.max(max, element);
        }
        return max;
    }
    
    // calculate the eat up time
    private int calTime(int[] piles, int speed) {
        int time = 0;
        // cast speed to double to get ceil
        // 1 - can also be done while passing the arugment
        // 2 - can be done via time += (pile - 1) / speed + 1
        // 3 - can be done via time += (pile + speed - 1) / speed
        double speedInDouble = (double) speed;
        for (int pile : piles) {
            time += Math.ceil(pile / speedInDouble);
        }

        return time;
    }
}