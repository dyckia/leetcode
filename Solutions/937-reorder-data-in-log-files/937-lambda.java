class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (log1, log2) -> {
            String[] arr1 = log1.split(" ", 2);
            String[] arr2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(arr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int diff = arr1[1].compareTo(arr2[1]);
                if (diff != 0) return diff;
                return arr1[0].compareTo(arr2[0]);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }
}

/*
Time: (slogs)
s is the total number of characters in the logs array

Space: (s)
mergesort for Arrays.sort() on objects (stable sort)
quicksort for Arrays.sort() on primitive types 
*/