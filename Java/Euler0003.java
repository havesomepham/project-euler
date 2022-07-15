// Potential Issues: does not check if currentFactor is prime; only assures it is odd.

public class Euler0003 {
    public static void main(String[] args) {
        double currentFactor = 1d;
        double greatestFactor = 1d;
        double NUM = 600851475143d;

    while (currentFactor <= NUM) {
        if (NUM % currentFactor == 0) {
            greatestFactor = currentFactor;
            NUM /= greatestFactor;
        }
        currentFactor += 2;
    }
    System.out.println((int)greatestFactor);
    }
}
