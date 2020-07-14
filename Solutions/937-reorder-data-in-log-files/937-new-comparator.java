class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<>() {
            @Override
            public int compare(String log1, String log2) {
                // index after identifier
                int ind1 = log1.indexOf(' ') + 1;
                int ind2 = log2.indexOf(' ') + 1;

                // or use log1.charAt(ind1) <= '9'
                // letter is greater than digit
                boolean isDigit1 = Character.isDigit(log1.charAt(ind1));
                boolean isDigit2 = Character.isDigit(log2.charAt(ind2));

                if (isDigit1) {
                    if (isDigit2) {
                        // both log1 and log2 are digit logs
                        // return 0 to retain original order
                        return 0;
                    } else {
                        // log1 is digit and log2 is letter
                        return 1;
                    }
                }

                // log1 is letter and log2 is digit
                if (isDigit2) return -1;

                // compare log content
                int diff = log1.substring(ind1).compareTo(log2.substring(ind2));
                if (diff != 0) return diff;
                return log1.substring(0, ind1 - 1).compareTo(log2.substring(0, ind2 - 1));
            }
        };

        Arrays.sort(logs, myComp);
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