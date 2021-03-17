class Solution {
    public boolean isRobotBounded(String instructions) {
        /*
         * If there is a circle, the robot returns to origin within at most 4 cycles
         * OR 
         *  1. If the robot returns to origin after cycle one 
         *  2. The robot is not facing north after cycle one 
         *  (symmetry, the robot will always return to origin with 4 cycles)
         */
        
        // 0-up 1-right 2-down 3-left
        int direction = 0;
        // if facing up, G moves (x+0, y)
        int x = 0;
        int y = 0;
        int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                x += moves[direction][0];
                y += moves[direction][1];
            } else if (instruction == 'L') {
                // turn 1 left equals to turn 3 right (prevent negetive remainder)
                direction = (direction + 3) % 4;
            } else {
                direction = (direction + 1) % 4;
            }
        }

        return (x == 0 && y == 0) || direction != 0;

    }
}