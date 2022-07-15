import java.math.BigDecimal;

public class Euler0016 {
    public static void main(String[] args) {
        BigDecimal NUM = new BigDecimal(Math.pow(2,1000)); // we use BigDecimal to preserve digit precision
        BigDecimal digitSum = new BigDecimal(0); // we use BigDecimal here as well since most operations in the BigDecimal class are incompatible with other types

        while (NUM.compareTo(BigDecimal.ONE) != -1) { // while NUM is not less than 1
            digitSum = digitSum.add(NUM.remainder(BigDecimal.TEN)); // digit of the ones place
            NUM = NUM.subtract(NUM.remainder(BigDecimal.TEN)); // subtract out ones place
            NUM = NUM.divide(BigDecimal.TEN); // and divide by 10
        }

        System.out.println(digitSum);
    }
}
