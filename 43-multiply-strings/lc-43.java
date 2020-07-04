class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        // final result in array form
        int[] arr = new int[n1 + n2];
        
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                // i * j goes to arr[i + j + 1] and arr[i + j]
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + arr[i + j + 1];
                arr[i + j + 1] = num % 10;
                arr[i + j] += num / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1 + n2; i++) {
            if (sb.length() == 0 && arr[i] == 0) continue;
            sb.append(arr[i]);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}