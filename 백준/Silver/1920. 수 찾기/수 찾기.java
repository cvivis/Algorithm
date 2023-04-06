import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N,M;
	static int[] input;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N;i++) {
			input[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(input);
		M = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < M;i++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(Arrays.binarySearch(input, num)<0) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
		}
		
		
	}
}
