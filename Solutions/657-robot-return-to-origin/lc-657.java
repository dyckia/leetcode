class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] movesArr = moves.toCharArray();

        // early stop
        if (movesArr.length % 2 != 0)
            return false;

        // use for each loop
        for (char c : movesArr) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x--;
            } else {
                x++;
            }
        }

        // no need to use if else statement as result is already boolean
        return x == 0 && y == 0;
    }
}