public class Task2 {
	public static final int LIMIT = 4000000;

	public static void main(String[] args) {
		int v1 = 1;
		int v2 = 2;
		long sum = 0;
		do {
			System.out.println(v2);
			sum += v2;
			int v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		} while(v2<LIMIT);
		System.out.println(sum);
	}

}