public class Task1 {
	public static final int LIMIT = 1000;
	public static void main(String[] args) {
		int sum = 0;
		int threes = 3;
		do {
			System.out.println(threes);
			sum += threes;
			threes = threes+3;
		} while(threes<LIMIT);
		int fives = 5;
		do {
			if (fives%3!=0) {
				System.out.println(fives);
				sum += fives;
			}
			fives = fives+5;
		} while(fives<LIMIT);
		System.out.println(sum);
	}
}