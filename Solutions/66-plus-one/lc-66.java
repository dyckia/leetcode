class Solution {
    // add one to end of the array
    // keep update the carryover while index is not less than 0
    // if carryover is still not equal to zero
    // create a new array of length (len + 1)

    public int[] plusOne(int[] digits) {
        int carryover = 1;
        for (int i = digits.length - 1; i >= 0 && carryover != 0; i++) {
            int result = digits[i] + carryover;
            digits[i] = result % 10;
            carryover = result / 10;
        }
        if (carryover == 0) return digits;
        
        int[] newDigits = new int[digits.length + 1];

        // carryover could only be 0 or 1
        newDigits[0] = 1;

        // below loop is not necessary since 
        // the only scenario to get a carryover of 1 at last is
        // 999999 + 1
        for (int i = 1; i < newDigits.length; i++) {
            newDigits[i] = digits[i - 1];
        }

        return newDigits;
    }
}

/*
Time: O(n)

Space: O(1)
*/