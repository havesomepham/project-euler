public class Euler0006 {
    public static void main(String[] args) {
        double sumOfSquares = 0d;
        double squareOfSum = 0d;

        for (double i = 1; i <= 100; i++) {
            sumOfSquares += Math.pow(i, 2);
            squareOfSum += i;
        }

        squareOfSum = Math.pow(squareOfSum, 2);
        System.out.println((int)(squareOfSum - sumOfSquares));
    }
}
