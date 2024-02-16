

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[N+1];
		arr[2]= 1;
		int count = 1;  //결과 확인용
		int result = 2;
		boolean finish = false;
		for(int i = 2; i <= N; i++) {
			int checkingNum = i;
			int forMul = 1;
			while(true) {
				if(checkingNum >N)break;
				if(arr[checkingNum] != 1) {
					arr[checkingNum] = 1;
					count++;
					result = checkingNum;
				}
				if(count == K) {
					finish = true;
					break;
				}
				forMul++;
				checkingNum = i * forMul;
			}
			if(finish)break;
		}
		System.out.println(result);
	}
}