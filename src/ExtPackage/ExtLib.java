package ExtPackage;

public final class ExtLib {

    public static double eval(int a, int p) {
        ExtLib.rangeCheck(a);
        return Math.pow(a, p);
    }

    private static void rangeCheck(int a) throws IllegalArgumentException {
        if (a < 1) {
            throw new IllegalArgumentException();
        }
    }

}
