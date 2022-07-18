/*
 * Euler 0004
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Euler0004 {

    // a recursive solution
    public static boolean isPalindrome(String str) {
        if (str.length() < 2) { // if the final string is zero or one char long, we've found a palindrome
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) { // if the first and last chars match...
            return isPalindrome(str.substring(1, str.length() - 1)); // ...cut them out and call isPalindrome on the shorter string
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int largestPalindrome = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                if (isPalindrome(Integer.toString(i * j)) && i * j > largestPalindrome) {
                    largestPalindrome = i * j;
                }
            }
        }

        System.out.println(largestPalindrome);
    }
}
