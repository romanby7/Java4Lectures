public class MathFunc {

    public static float pow(long arg, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1)  {
            return arg;
        }
        else if (power >= 1) {
            return arg * pow(arg, --power);
        }
        else {
            return (float) 1/pow(arg, -power);
        }
    }

}
