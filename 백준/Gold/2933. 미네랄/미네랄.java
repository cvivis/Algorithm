import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 완전탐색 + 시뮬레이션
// 1.막대기 방향 boolean으로 스위칭
// 2. 막대기는 해당 높이에서 가로방향으로 처음만나는 미네랄 없에기
// 3. 없애고 나서 해당 위치의 4방탐색으로 미네랄 있으면 완점탐색으로 덩어리 뽑기


public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int R, C;
	static char[][] input;
	static boolean left = true, right = false;
	static boolean barDir = left;
	static boolean[][] visit;
	static boolean[][] mineral;
	static List<Loc[]> mineralGroup = new ArrayList<>();
	static int barCount;
	static int[] barHeight;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean levitation;

	static class Loc implements Comparable<Loc> {
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

		@Override
		public int compareTo(Loc o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.x, o.x) * -1;
		}

	}

	private static boolean isIn(int x, int y) {
		return x >= 1 && y >= 1 && x <= R && y <= C;
	}

	private static List<Loc> bfs(Loc startLoc) { // 공중부양 여부 , 공중부양인 클러스터 좌표
//		System.out.println(startLoc);
//		System.out.println("startLoc" + startLoc);
		Queue<Loc> q = new ArrayDeque<>();

		levitation = true;
		List<Loc> clust = new ArrayList<>();
		if (mineral[startLoc.x][startLoc.y] && !visit[startLoc.x][startLoc.y]) {
//			System.out.println("asdfSDf");
			q.offer(startLoc);
			clust.add(startLoc);
		}
		visit[startLoc.x][startLoc.y] = true;
		while (!q.isEmpty()) {
			Loc nowLoc = q.poll();
			int x = nowLoc.x;
			int y = nowLoc.y;
            mineral[x][y] = false;
			if (x == R)
				levitation = false;
			for (int i = 0; i < deltas.length; i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				if (isIn(nx, ny) && mineral[nx][ny] && !visit[nx][ny]) {
					Loc nextLoc = new Loc(nx, ny);
					q.offer(nextLoc);
					clust.add(nextLoc);
					visit[nx][ny] = true;
				}
			}
		}
		return clust;
	}

	static void drop(List<Loc> clust) {
//		System.out.println("drop");
//		System.out.println("pqSize: "+ clust.size());
//		System.out.println("pq: " + clust);
//		int h = R - clust.peek().x;
		int h = R;
		boolean[][] temp = new boolean[R+1][C+1];
//		System.out.println("xxx");
		for (int i = 0; i < clust.size(); i++) {
			Loc now = clust.get(i);
			int nextH = R - now.x;
			for(int r = now.x + 1;r<=R;r++) {
				if(mineral[r][now.y] && !temp[r][now.y]) {

					nextH = Math.min(nextH, r - now.x - 1);
				}
			}
			h = Math.min(h, nextH);
		}
//		System.out.println("h: "+ h);
		for (Loc loc : clust) {
			mineral[loc.x + h][loc.y] = true;
		}

	}

	private static Loc throwBar(int height) {
		Loc breakLoc = null;
		if (barDir == left) { //
			for (int i = 1; i <= C; i++) {
				if (mineral[height][i]) {
					breakLoc = new Loc(height, i);
					mineral[height][i] = false;
					break;
				}
			}
		} else {
			for (int i = C; i >= 1; i--) {
				if (mineral[height][i]) {
					breakLoc = new Loc(height, i);
					mineral[height][i] = false;
					break;
				}
			}
		}
		barDir = !barDir;
		return breakLoc;
	}

	private static int changeHeight(int height) {
		return R + 1 - height;
	}

	private static void printMineral() {
//		System.out.println("=====================");
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (mineral[i][j]) {
					System.out.print("x");
				} else {
					System.out.print(".");
				}

			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		input = new char[R + 1][C + 1];

		mineral = new boolean[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				input[i][j] = str.charAt(j - 1);
				if (input[i][j] == 'x') {
					mineral[i][j] = true;
				}
			}
		}
//		for (char[] arr : input) {
//			System.out.println(Arrays.toString(arr));
//		}
		barCount = Integer.parseInt(br.readLine());
		barHeight = new int[barCount];
		tokens = new StringTokenizer(br.readLine());

		for (int i = 0; i < barCount; i++) {
			barHeight[i] = Integer.parseInt(tokens.nextToken());
		}
		for (int i = 0; i < barCount; i++) {
			int myH = changeHeight(barHeight[i]);
			Loc breakLoc = throwBar(myH);
//			printMineral();
			visit = new boolean[R + 1][C + 1];
			if (breakLoc != null) {
				for (int d = 0; d < deltas.length; d++) {
					int nx = breakLoc.x + deltas[d][0];
					int ny = breakLoc.y + deltas[d][1];
					
					if (isIn(nx, ny)) {
						Loc nLoc = new Loc(nx, ny);

						List<Loc> clust = bfs(nLoc);
//						System.out.println(clust);
						if (levitation && !clust.isEmpty()) {
							drop(clust);
							break;
						}
                        else {
							for(Loc loc : clust) {
								mineral[loc.x][loc.y] = true;
							}
						}

					}
				}
			}

		}
//		for (boolean[] arr : mineral) {
//			System.out.println(Arrays.toString(arr));
//		}
		printMineral();
	}
}
