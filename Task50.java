public class Task50 {

    private static final int MAX_NUMBER = 1000000;

    private static final int SIEVE_SIZE = MAX_NUMBER+1; //1000000;
    private static final int SIEVE_CELLS = (SIEVE_SIZE)/64+1;

    // contains 1 for non prime numbers
    private static long[] sieve = new long[SIEVE_CELLS];

    public static int prevPrime(int from) {
        from--;
        while((sieve[from/64]&(1L<<(from%64)))!=0) from--;
        return from;
    }

    public static int nextPrime(int from) {
        from++;
        while((sieve[from/64]&(1L<<(from%64)))!=0) from++;
        return from;
    }

    public static boolean isPrime(int number) {
        return (sieve[number/64]&(1L<<(number%64)))==0;
    }

    public static void main(String[] args) {
        int current = 1;
        int primeCount = 0;
        do {
            current++;
            while ((sieve[current/64]&(1L<<(current%64)))!=0) current++;
            if (current<SIEVE_SIZE) {
                primeCount++;
            }
            for(int i=current*2;i<SIEVE_SIZE;i+=current) {
                sieve[i/64] |= 1L<<(i%64);
            }
        } while(current<SIEVE_SIZE);

        int currentStart = 1;
        int currentEnd = 1;
        int maxSeqFound = 0;
        int maxSeqValue = 0;
        int sum;
        int length;
        do {
            currentStart = nextPrime(currentStart);
            sum = currentStart;
            length = 1;
            currentEnd = currentStart;
            do {
                currentEnd = nextPrime(currentEnd);
                sum+=currentEnd;
                length++;
                if (sum<MAX_NUMBER && isPrime(sum)) {
                    if (length>maxSeqFound) {
                        maxSeqFound = length;
                        maxSeqValue = sum;
                    }
                }
            } while(sum<MAX_NUMBER && currentEnd<MAX_NUMBER);

        } while(currentStart<MAX_NUMBER);
        System.out.println("Found seq below " + MAX_NUMBER + " ending at " + maxSeqValue + " length is " + maxSeqFound);
    }
}
