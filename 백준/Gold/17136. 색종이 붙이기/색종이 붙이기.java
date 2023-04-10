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
	static int[][] input;
	static boolean[][] visit;
	static int cofettiCount = 0;
	static int[] cofettis = { 5, 5, 5, 5, 5 };
	static int min = Integer.MAX_VALUE;
	static int selectCofetti = 0;
	static boolean checkOver = false;

	private static boolean checkTrue(int x, int y, int len) {
		for (int i = 0; i <= len; i++) {
			int nx = x + i;
			for (int j = 0; j <= len; j++) {
				int ny = y + j;
				if(isIn(nx,ny)) {
					if(input[nx][ny] != 1 || visit[nx][ny])return false;
				}else {
					return false;
				}
			}
		}
		return true;

	}
	
	private static boolean isIn(int x ,int y) {
		return x >= 0 && y >= 0 && x < 10 && y < 10;
	}

	private static void selectConfetti(int x, int y, int len) {
		for (int i = 0; i <= len; i++) {
			int nx = x + i;
			for (int j = 0; j <= len; j++) {
				int ny = y + j;
				if(isIn(nx,ny)) {
					if (!visit[nx][ny]) {
						cofettiCount--;
						visit[nx][ny] = true;
					} else {
						cofettiCount++;
						visit[nx][ny] = false;
					}
				}

			}
		}
		if (cofettiCount == 0) {
//			checkOver = true;
//			System.out.println(selectCofetti);
			if (min > selectCofetti)
				min = selectCofetti;
		}
	}

	private static void dfs(int idx) {
		int x = idx / 10;
		int y = idx % 10;
//		System.out.println(idx);
		if(idx >= 100)return;
		if(input[x][y] == 1 && !visit[x][y]) {
			for(int i = 0; i<5;i++) {
				if(cofettis[i] == 0)continue;
				if(checkTrue(x, y, i)) {
					selectCofetti++;
					selectConfetti(x,y,i);
					cofettis[i]--;
//					System.out.println("asdf");
					dfs(idx+1);
					cofettis[i]++;
					selectCofetti--;
					selectConfetti(x,y,i);
				}
			}
		}
		else {
			dfs(idx+1);
		}

	}

	public static void main(String[] args) throws IOException {

		input = new int[10][10];
		visit = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				input[i][j] = Integer.parseInt(tokens.nextToken());
				if (input[i][j] == 1) {
//					min = 0;
					cofettiCount++;
				}
			}
		}
//		System.out.println(cofettiCount);
		dfs(0);
		if (cofettiCount != 0) {
			if (min == Integer.MAX_VALUE)min = -1;
				
			System.out.println(min);
		} else {
			System.out.println("0");
		}

//		for(int i = 0 ; i < 10;i++) {
//			for(int j = 0; j < 10;j++) {
//				if(input[i][j] == 1) {
//					visit[i][j] = true;
//				}
//			}
//		}
	}
}
