// The challenge of this problem was to accurately write out a long if-else statement to weed out the complexities of number-words like "nine, ten, eleven, ... , nineteen, twenty, twenty one" etc, without literally just writing out all the numbers manually.

public class Euler0017 {

    public static String[] bases = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

    public static String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
            "ninety" };

    public static String hundred = "hundred";
    public static String thousand = "thousand";
    public static String and = "and";

    public static int letterCount(int n) {
        if (n < 20) { // [0, 19]
            return bases[n].length();
        } else if (n < 100) { // [19, 99]
            return tens[(n - (n % 10)) / 10].length() + bases[n % 10].length();
        } else if (n == 1000) {
            return thousand.length() + bases[1].length();
        } else {
            if (n % 100 == 0) { // {100, 200, ..., 900}
                return bases[n / 100].length() + hundred.length();
            } else if (n % 100 < 20) { // {101, 102, ... 119, 201, ... 919}
                return bases[(n - (n % 100)) / 100].length() + and.length() + hundred.length()
                        + bases[n % 100].length();
            } else {
                return bases[(n - (n % 100)) / 100].length() + and.length() + hundred.length()
                        + tens[((n - (n % 10)) / 10) % 10].length() + bases[n % 10].length();
            }
        }
    }

    public static void main(String[] args) {

        int totalLetters = 0;

        for (int i = 1; i <= 1000; i++) {
            totalLetters += letterCount(i);
        }

        System.out.println(totalLetters);
    }
}
