/*
if there are x soldiers before j whose rating is less than rating[j]
and y soldiers after j whose rating is greater than rating[j]
then 
num(rating[i] < rating[j] < rating[k]) = x * y
num(rating[i] > rating[j] > rating[k]) = (j - x) * (n - 1 - j - y)
j starts from 0
*/

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int j = 0; j < n; j++) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) x++;
            }
            for (int k = j + 1; k < n; k++) {
                if (rating[j] < rating[k]) y++;
            }
            res += x * y;
            res += (j - x) * (n - 1 - j - y);
        }
        return res;
    }
}

/*
Time: n^3

Space: n
*/