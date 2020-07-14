class Solution {
    public List<String> fizzBuzz(int n) {
        // User counter instead of reaminder operation as reaminder operation is expensive 
        List<String> res = new LinkedList<String>();
        int counter3 = 0;
        int counter5 = 0;
        
        for (int i = 1; i <= n; i++) {
            counter3++;
            counter5++;
            if (counter3 == 3 && counter5 == 5) {
                res.add("FizzBuzz");
                counter3 = 0;
                counter5 = 0;
            } else if (counter3 == 3) {
                res.add("Fizz");
                counter3 = 0;
            } else if (counter5 == 5) {
                res.add("Buzz");
                counter5 = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        
        return res;
    }
}