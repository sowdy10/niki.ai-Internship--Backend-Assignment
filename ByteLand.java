import java.util.Scanner;

public class ByteLand {

	static int mod = (int) Math.pow(10, 9) + 7;

	public int bitLength(long n) {

		int count = fibMod(n + 2);

		return count;

	}

	private int fibMod(long n) {

		int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(F, n - 1);
		int res = F[0][0] % mod;
		return res;
	}

	private void power(int F[][], long n) {
		if (n == 0 || n == 1)
			return;
		int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	private void multiply(int F[][], int M[][]) {
		int a = F[0][0] * M[0][0] + F[0][1] * M[1][0];
		int b = F[0][0] * M[0][1] + F[0][1] * M[1][1];
		int c = F[1][0] * M[0][0] + F[1][1] * M[1][0];
		int d = F[1][0] * M[0][1] + F[1][1] * M[1][1];

		F[0][0] = a;
		F[0][1] = b;
		F[1][0] = c;
		F[1][1] = d;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {

			int n = sc.nextInt();
			ByteLand B = new ByteLand();
			int count = B.bitLength(n);
			System.out.println(count);

		}
		// TODO Auto-generated method stub

	}

}
