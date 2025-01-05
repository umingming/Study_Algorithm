package leetcode;

/**
 * 5. Longest Palindromic Substring
 * Attempted
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        System.out.println(solution.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int startIndex = 0;
        int endIndex = 0;

        for(int i=0; i<s.length(); ++i) {
            int oddExpend = expendFromCenter(s, i, i);
            int evenExpend = expendFromCenter(s, i, i+1);

            int maxLength = Math.max(oddExpend, evenExpend);

            if(maxLength > endIndex - startIndex) {
                startIndex = i - (maxLength - 1) / 2;
                endIndex = i + (maxLength / 2);
            }

        }
        return s.substring(startIndex, endIndex + 1);
    }

    public int expendFromCenter(String s, int lt, int rt) {
        while (lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
            lt--;
            rt++;
        }

        return rt - lt -1;
    }

}
