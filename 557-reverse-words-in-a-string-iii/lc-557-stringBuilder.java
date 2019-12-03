// split and reverse
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverseWord(word));
            sb.append(" ");
        }
        // remove space in the last position
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private String reverseWord(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    } 
}