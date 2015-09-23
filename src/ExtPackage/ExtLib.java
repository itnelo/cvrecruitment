package ExtPackage;

public final class ExtLib {

    public static int eval(int a, int p) {
        ExtLib.rangeCheck(a);
        return (int)Math.pow(a, p);
    }

    private static void rangeCheck(int a) throws IllegalArgumentException {
        if (a < 1) {
            throw new IllegalArgumentException();
        }
    }

}
