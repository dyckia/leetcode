class Solution {
    String[] phone;

    public List<String> letterCombinations(String digits) {
        initializePhoneBook();
        Deque<String> queue = new ArrayDeque<>();
        if (digits.length() == 0) return new ArrayList(queue);
        
        queue.offer("");
        
        for (int i = 0; i < digits.length(); i++) {
            String charString = phone[digits.charAt(i) - '0' - 2];
            for (int j = queue.size(); j > 0; j--) {
                String prefix = queue.poll();
                for (char c : charString.toCharArray()) {
                    String newPrefix = prefix + c;
                    queue.offer(newPrefix);
                }
            }
        }
        
        return new ArrayList(queue);
    }

    private void initializePhoneBook() {
        phone = new String[8];
        phone[0] = "abc";
        phone[1] = "def";
        phone[2] = "ghi";
        phone[3] = "jkl";
        phone[4] = "mno";
        phone[5] = "pqrs";
        phone[6] = "tuv";
        phone[7] = "wxyz";
    }
}

/*
Time: O(4^n)
n is the digits length
For each digit there are at most 4 options

Space: O(4^n)
*/