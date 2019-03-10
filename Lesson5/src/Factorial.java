public class Factorial {

    public static void main(String[] args) {
        //5! = 5 * 4 * 3 * 2 * 1
        //3! = 3 * 2 * 1
        System.out.println(factorial(5));
    }

    private static int factorial(int number) {
        if (number <= 1) {
            return number;
        }
        else {
            return number * factorial(number - 1);
        }
    }
}
