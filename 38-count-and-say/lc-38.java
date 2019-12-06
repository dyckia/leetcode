class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        while (--n >= 1) {
            ans = nextNumber(ans);
        }
        return ans;
    }
    
    private String nextNumber(String prev) {
        StringBuilder sb = new StringBuilder();
        char[] arr = prev.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            int count = 1;
            while (i + 1 < arr.length && arr[i + 1] == cur) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(cur);
        }

        return sb.toString();
    }
}