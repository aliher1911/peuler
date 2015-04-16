public class Task50 {

    private static final int SIEVE_SIZE = 50; //1000000;
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

    public static void main(String[] args) {
        int current = 1;
        int primeCount = 0;
        do {
            current++;
            while ((sieve[current/64]&(1L<<(current%64)))!=0) current++;
            if (current<SIEVE_SIZE) {
//                System.out.println("Prime=" + current);
                primeCount++;
            }
            for(int i=current*2;i<SIEVE_SIZE;i+=current) {
                sieve[i/64] |= 1L<<(i%64);
            }
        } while(current<SIEVE_SIZE);
        System.out.println("Prime numbers found " + primeCount);
        // for each prime starting from greatest
       
        current = 1;
        int seqEnd = 0;
        int seqLength = 0;
        do {
            current = nextPrime(current);
            
        } while(current<SIEVE_SIZE);
        System.out.println("Found seq ending at " + seqEnd + " length is " + seqLength);
 
    }
}
