public class Task48 {

    public static final long MAX_NUMBER = 1000L;

    public static final long RESULT_MASK = 10000000000L;

    private static long part(long value) {
        long product = 1;
        for(long i=1;i<=value;i++) {
            product *= value;
            product %= RESULT_MASK;
        }
        return product;
    }

    public static void main(String[] args) {
        long sum = 0;
        for(int i=1;i<=MAX_NUMBER;i++) {
            // ;-)
            long partialSum = part(i);
            System.out.println("Partial for " + i + " is " + partialSum);
            sum += partialSum;
            sum %= RESULT_MASK;
        }
        System.out.println("Sum="+sum);
    }
}