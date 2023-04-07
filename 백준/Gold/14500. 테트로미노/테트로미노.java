import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static int[][] input;
	static int[][] deltas = {{0,1},{-1,0},{0,-1},{1,0}};
	static boolean[][] visit;
	static int max = Integer.MIN_VALUE;
	static boolean[][] visitT;
	
	static class Loc{
		int x;
		int y;
		int d;
		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		public Loc(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	
	private static void dfs(Loc loc,int sum) {
		if(loc.d == 3) {
			if(max < sum)max =sum;
			return;
		}
		for(int i = 0; i < 4;i++) {
			int nx = loc.x + deltas[i][0];
			int ny = loc.y + deltas[i][1];
			if(isIn(nx,ny) && !visit[nx][ny]) {
				visit[nx][ny] = true;
				dfs(new Loc(nx,ny,loc.d+1),sum+input[nx][ny]);
				visit[nx][ny] = false;
			}
		}
	}
	
	private static void reverseT(Loc loc) {
		for(int i = 0; i < deltas.length;i++) {
			int temp = input[loc.x][loc.y];
			int nx = loc.x;
			int ny = loc.y;
			for(int j = 0; j < 2;j++) {
				nx = nx +deltas[i][0];
				ny = ny +deltas[i][1];

				if(!isIn(nx,ny))break;
				temp+=input[nx][ny];
				if(j == 0) {
					if(i % 2== 0) {
						int up = 0;
						int down = 0;
						if(isIn(nx-1,ny)) {
							up = input[nx-1][ny];
						}
						if(isIn(nx+1,ny)) {
							 down = input[nx+1][ny];
						}
						temp+=Math.max(up,down);
					}
					else {
						int left = 0;
						int right = 0;
						if(isIn(nx,ny-1)) {
							left = input[nx][ny-1];
						}
						if(isIn(nx,ny+1)) {
							 right = input[nx][ny+1];
						}
						temp+=Math.max(left,right);

					}
				}
			}

			if(max < temp)max = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		input = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		visit = new boolean[N][M];
		visitT = new boolean[N][M];
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < M;j++) {
				visit[i][j] = true;
				dfs(new Loc(i,j,0),input[i][j]);
				visit[i][j] = false;
					reverseT(new Loc(i,j,0));
			}
		}
		System.out.println(max);
	}

}
