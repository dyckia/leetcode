class Solution {
    String[] phone;

    public List<String> letterCombinations(String digits) {
        initializePhoneBook();
        List<String> res = new ArrayList<String>();
        if (digits != null && digits.length() > 0) {
            backtracking(new StringBuilder(), digits, 0, res);
        }
        return res;
    }

    private void backtracking(StringBuilder sb, String digits, int ind, List<String> res) {
        if (ind == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String charString = phone[digits.charAt(ind) - '0' - 2];
        for (char c : charString.toCharArray()) {
            backtracking(sb.append(c), digits, ind + 1, res);
			// delete the last added char in the StringBuilder
            sb.deleteCharAt(sb.length() - 1);
        }

        return;
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

Space: O(1)
*/