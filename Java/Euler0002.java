public class Euler0002 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int space;
        int sum = 0;

        while(a < 4000000) {
            if (a % 2 == 0) {
                sum += a;
            }
            space = a;
            a = b;
            b += space;
        }
        System.out.println(sum);
    }
}
