import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int R, C;
	static int[][] input;
	static int[][] waterD;
	static int[][] dochiD;
	static int[][] result;
	static final int WATER = 1, DOCHI = 2, BEAVER = 3, ROCK = 4;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[] waterLoc = new int[2];
	static int[] dochiLoc = new int[2];
	static int[] beaverLoc = new int[2];
	static boolean waterIn = false;
	static List<int[]> waterList = new ArrayList<>();

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}

	private static void bfs(int firstX, int firstY, int[][] arr, int status) {
		boolean[][] visit = new boolean[R][C];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { firstX, firstY });
		visit[firstX][firstY] = true;
		result = new int[R][C];
		arr[firstX][firstY] = 0;

		while (!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			for (int i = 0; i < deltas.length; i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				if (isIn(nx, ny) && !visit[nx][ny] && input[nx][ny] != ROCK) {
					if(status == WATER && input[nx][ny] == BEAVER) {
//						waterD[nx][ny] = Integer.MAX_VALUE;
						continue;
					}
					if (status == WATER) {
						arr[nx][ny] = Math.min(arr[nx][ny], arr[x][y] + 1);
					}
                    else {
						arr[nx][ny] = arr[x][y] + 1;
					}
					q.offer(new int[] { nx, ny });
					visit[nx][ny] = true;
					
				}
			}
		}
//		for (int[] num : arr) {
//			System.out.println(Arrays.toString(num));
//		}
//		System.out.println("===================");
	}

	private static int bfsResult(int firstX, int firstY, int[][] arr) {
		boolean[][] visit = new boolean[R][C];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { firstX, firstY });
		visit[firstX][firstY] = true;
		arr[firstX][firstY] = 0;

		while (!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];

			for (int i = 0; i < deltas.length; i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				if (isIn(nx, ny) && !visit[nx][ny] && input[nx][ny] != ROCK && dochiD[nx][ny] < waterD[nx][ny]) {
					q.offer(new int[] { nx, ny });
					visit[nx][ny] = true;
					arr[nx][ny] = arr[x][y] + 1;
					if (nx == beaverLoc[0] && ny == beaverLoc[1]) {
						return arr[x][y] + 1;
					}
				}
			}
		}
//		for (int[] num : arr) {
//			System.out.println(Arrays.toString(num));
//		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		input = new int[R][C];
		dochiD = new int[R][C];
		waterD = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				waterD[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				if (c == '*') {
					input[i][j] = WATER;
					waterLoc = new int[2];
					waterLoc[0] = i;
					waterLoc[1] = j;
//					System.out.println(i + " " + j);
					waterIn = true;
					waterList.add(waterLoc);
				}

				else if (c == 'D') {
					input[i][j] = BEAVER;
					beaverLoc[0] = i;
					beaverLoc[1] = j;

				}

				else if (c == 'S') {
					input[i][j] = DOCHI;
					dochiLoc[0] = i;
					dochiLoc[1] = j;
				}

				else if (c == 'X') {
					input[i][j] = ROCK;
				}

				else {
					input[i][j] = 0;
				}
			}
		}
//		System.out.println(waterLoc[0]+" "+ waterLoc[1]);
		int find = 0;
		if (waterIn) {
			for(int[] waterLoc : waterList) {
//				System.out.println(Arrays.toString(waterLoc));
				bfs(waterLoc[0], waterLoc[1], waterD, WATER);
			}
			bfs(dochiLoc[0], dochiLoc[1], dochiD, DOCHI);
//			for (int[] arr : waterD) {
//				System.out.println(Arrays.toString(arr));
//			}
//			System.out.println("==============");
//			for (int[] arr : dochiD) {
//				System.out.println(Arrays.toString(arr));
//			}
			find = bfsResult(dochiLoc[0], dochiLoc[1], result);
//			System.out.println("==============");
//			for (int[] arr : result) {
//				System.out.println(Arrays.toString(arr));
//			}
		} else {
			bfs(dochiLoc[0], dochiLoc[1], dochiD, DOCHI);

			find = dochiD[beaverLoc[0]][beaverLoc[1]];
		}

		if (find == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(find);
		}

	}
}
