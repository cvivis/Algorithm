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
	static int[] findLis;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		findLis = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(findLis, Integer.MAX_VALUE);
		for(int i = 0 ; i < N;i++) {
			int idx = Arrays.binarySearch(findLis, input[i]) * (-1) -1;
			findLis[idx] = input[i];
		}
		
		int lisLen= N;
		for(int i = 0; i <N;i++) {
			if(findLis[i] == Integer.MAX_VALUE) {
				lisLen = i;
				break;
			}
		}
//		System.out.println(Arrays.toString(findLis));
		System.out.println(N - lisLen);
		
	}
}
