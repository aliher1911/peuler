public class Task3 {
	
	public static final long NUMBER = 600851475143L;

	private static final int SIEVE_SIZE = 100000000;
	private static final int SIEVE_CELLS = (SIEVE_SIZE)/64+1;

	private static long[] sieve = new long[SIEVE_CELLS];

	private static void dump() {
		for(int i=0;i<SIEVE_CELLS;i++) {
			System.out.println(String.format("%64s", Long.toBinaryString(sieve[i])).replace(' ', '0'));
		}
	}

	public static void main(String[] args) {
		int current = 1;
		long lastDivisor = 0;
		long rebuilt = 1;
//		dump();
		do {
			current++;
			while ((sieve[current/64]&(1L<<(current%64)))!=0) current++;
			if (current<SIEVE_SIZE) {
//				System.out.println("Next " + current);
				if (NUMBER%current==0) {
					lastDivisor = current;
					rebuilt *= current;
					System.out.println("Can divide by " + current + " remainder " + (NUMBER/current));
				}
			}
			for(int i=current*2;i<SIEVE_SIZE;i+=current) {
//				System.out.println("Blocking " + i/64 + "(" + (i%64) + ") = " + (1<<(i%64)) );
				sieve[i/64] |= 1L<<(i%64);
			}
//			dump();
		} while(current<SIEVE_SIZE);
		if (lastDivisor<SIEVE_SIZE) {
			System.out.println("Answer =   " + lastDivisor);
			System.out.println("Rebuilt =  " + rebuilt);
			System.out.println("Expected = " + NUMBER);
		}
	}
}