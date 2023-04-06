import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T;
	static int N, R;
	static long result;
	static long D[];
	static long p = 1_000_000_007l;

	private static void fac() {
		D = new long[4000001];
		D[0] = 1;
		for (int i = 1; i <= 4000000; i++) {
			D[i] = D[i - 1] * i % p;
		}
	}

	private static long pow(long base, long exp) {
		if (exp == 0)
			return 1;
		else if (exp == 1)
			return base;
		long res = pow(base,exp/2) % p;
		res = res * res % p;
		if(exp % 2 == 1)res = res * base % p;
		return res;
		
	}

	public static void main(String[] args) throws IOException {
//		T = Integer.parseInt(br.readLine());
//		int t;
		fac();
//		for (t = 1; t <= T; t++) {
			long result = 0;
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
//			System.out.println(D[N]);
//			System.out.println(D[R]);
//			System.out.println(D.length);
			long num = D[N] ;
			long num1= D[R] * D[N-R] % p;
			result = num * pow(num1,p-2) %p;
			output.append(+result +"\n");
			
//		}
		System.out.println(output);
	}
}
