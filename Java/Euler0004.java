/*
 * Euler 0004
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Euler0004 {
    
    // check if n is a palindrome
    public static boolean palindromeCheck(int n) { 
        String str = Integer.toString(n);
        String head, tail;
        
        // cut the number String into two parts to be compared
        if (str.length() % 2 == 0) { // if the palindrome has an even number of digits
            head = str.substring(0, str.length()/2);
            tail = str.substring(str.length()/2);
        } else {
            head = str.substring(0, (str.length() - 1)/2);
            tail = str.substring((str.length() + 1)/2 );
        }
        if (head.equals(stringReversal(tail))) {
            return true;
        } else {
            return false;
        }
    }

    // return reversed string
    public static String stringReversal(String str) {
        String reversed = "";
        for (int i = 0; i < str.length(); i++) {
            String ch = Character.toString(str.charAt(str.length() - i - 1));
            reversed = reversed.concat(ch);
        }
        return reversed;
    }

    public static void main(String[] args) {
        int largestPalindrome = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                if (palindromeCheck(i*j) && i*j > largestPalindrome) {
                    largestPalindrome = i*j;
                }
            }
        }

        System.out.println(largestPalindrome);
    }
}
