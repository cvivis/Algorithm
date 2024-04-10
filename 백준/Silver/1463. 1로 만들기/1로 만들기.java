import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[] input;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		input[1] = 0;
		if(N>=2) {
			input[2] = 1;
		}
		if(N>=3) {
			input[3] = 1;
		}
		int result = 0;
		for (int i = 4; i <= N; i++) {
			result = input[i - 1]+1;
			int num2 = 0;
			int num3 = 0;
			if (i % 2 == 0) {
				num2 = input[i / 2]+1;
				result = Math.min(result, num2);
			}
			if (i % 3 == 0) {
				num3 = input[i / 3]+1;
				result = Math.min(result, num3);
			}
			input[i]= result;
		}
//		System.out.println(Arrays.toString(input));
		System.out.println(input[N]);
	}
}
