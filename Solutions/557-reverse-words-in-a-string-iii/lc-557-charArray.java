// convert to char array and reverse each word
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0,
            end = 0;
        for (; end < arr.length; end++) {
            if (arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }
        // reverse last word
        // if last char is ' ', do nothing (start > end)
        reverse(arr, start, end - 1);
        return new String(arr);
    }
    
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return;
    } 
}