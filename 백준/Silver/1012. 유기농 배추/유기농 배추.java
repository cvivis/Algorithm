import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T;
	static int N, M, K;
	static int[][] input;
	static int result;
	static boolean[][] visit;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

	static class Loc {
		int x;
		int y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}

	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	private static void bfs(Loc loc) {
		Queue<Loc> q = new ArrayDeque<>();
		q.offer(loc);
		visit[loc.x][loc.y] = true;
		while(!q.isEmpty()) {
			Loc nowLoc = q.poll();
			int x = nowLoc.x;
			int y = nowLoc.y;
			for(int i = 0;i < deltas.length;i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny] == 1) {
					q.offer(new Loc(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		int t;
		for (t = 1; t <= T; t++) {
			int result = 0;
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			visit = new boolean[N][M];
			input = new int[N][M];
			for (int i = 0; i < K; i++) {
				tokens = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				input[x][y] = 1;
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(input[r][c] == 1 && !visit[r][c]) {
						Loc startLoc = new Loc(r,c);
						bfs(startLoc);
						result++;
					}

				}
			}
			output.append(result + "\n");

		}
		System.out.println(output);
	}
}
