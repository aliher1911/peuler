public class Task31 {

	public static final int NEEDED_SUM = 200;
	public static final int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};

	private static int solution(int fromSet, int remainingSum) {
		if (remainingSum==0) return 1;
		if (fromSet==COINS.length) return 0;
		int fits = 0;
		int currentCoin = COINS[fromSet];
		int maxFit = remainingSum/currentCoin;
		for(int i=0;i<=maxFit;i++) {
			fits += solution(fromSet+1, remainingSum-i*currentCoin);
		}
		return fits;
	}

	public static void main(String[] args) {
		System.out.println("Answer=" + solution(0, NEEDED_SUM));
	}
}