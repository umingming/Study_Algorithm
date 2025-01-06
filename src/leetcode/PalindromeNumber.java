package leetcode;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return sb.toString().contentEquals(sb.reverse());
    }
}
