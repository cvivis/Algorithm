import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[] input;
	static final int INF = Integer.MAX_VALUE, NO = Integer.MIN_VALUE;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(tokens.nextToken());
		}
		int a = INF;
		int b = INF;
//		System.out.println(-1 % -3);

		if (N >= 3) { // 3개 이상일때 
			if (input[0] - input[1] == 0) { // 앞에 같은거면 뒤에도 같은거
				for(int i = 0;i<N;i++) {
					if(input[i] != input[0]) {
						result = NO;
						break;
					}
				}
				if(result != NO) {
					a = 1;
					b = 0;
				}
				
			} else {  // 다르면 규칙찾기
				if( (input[2] - input[1]) % (input[1] - input[0]) != 0) { // *a가 정수가아닐때
//					System.out.println("asdf");
					result = NO;
				}else {
					a = (input[2] - input[1]) / (input[1] - input[0]); // 계산하기
					b = input[1] - input[0] * a;
					for (int i = 0; i < N - 1; i++) {
						if (input[i] * a + b != input[i + 1]) { //확인중에 뜬금포 나오기
							result = NO;
							break;
						}
					}
				}
			} 
			if(result != NO) { // 완벽쿠데스
				result = input[N - 1] * a + b;
			}
		}

		else if(N == 2){ // 2개일때
			if (input[0] == input[1]) { //앞에꺼 같으면 
				result = input[0]; 
			} else { 
				result = INF;
			}

		}
		else {
			result = INF;
		}
		
		if (result == INF) {
			System.out.println("A");
		} else if (result == NO) {
			System.out.println("B");
		} else {
			System.out.println(result);
		}

	}
}
