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
	static int[] stair;
	static int result = Integer.MIN_VALUE;
	static int[][] D;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		stair = new int[N];
		for (int i = 0; i < N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		D = new int[N][2];
		D[0] = new int[] {stair[0],0};
	    if(N>1) {
			D[1] = new int[] {stair[0] + stair[1] , stair[1]};
		}
		
		for(int i = 2;i<N;i++) {
			D[i][0] = D[i-1][1]+stair[i];
			D[i][1] = Math.max(D[i-2][0], D[i-2][1])+stair[i];
		}
		
//		for (int[] arr : D) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		result = Math.max(D[N-1][0], D[N-1][1]);
		
		System.out.println(result);
	}
}
