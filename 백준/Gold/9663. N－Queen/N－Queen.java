import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[] row, col;
	static boolean[][] visit;
	static int result = 0;
	
	private static boolean queenCheck(int x,int y) {
//		System.out.println(x + " "+ y);
		for(int i = 0; i < x;i++) {
			
			if(row[i] == y) {
//				System.out.println("조건1");
				return false;
			}
//			System.out.println(Math.abs(y - x) + " "+Math.abs(i - col[i]));
			if((y + x) == (row[i] + i)) {
//				System.out.println("조건2");
				return false;
			}
			if((y - x) == (row[i] - i)) {
//				System.out.println("조건3");
				return false;
			}
		}
		return true;
	}
	
	private static void recur(int x) {
		if(x == N) {
			
			result++;
			return;
		}
//		System.out.println(Arrays.toString(row));
		for(int y = 0 ; y < N;y++) {
			
			if(queenCheck(x,y)) {
//				col[y] = x;
				row[x] = y;
//				System.out.println("왔당1");
				recur(x+1);
				row[x] = -1;
			}
//			col[y] = -1;

		}
		
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
//		visit = new boolean[N][N];
		col = new int[N];
		row = new int[N];
//		Arrays.fill(col, -1);
		Arrays.fill(row, -1);
//		dia1 = new boolean[2 * N - 1];
//		dia2 = new boolean[2 * N - 1];
		recur(0);
		System.out.println(result);
		

	}
}
