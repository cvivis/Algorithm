/**
 * [키워드] 조합 + 시뮬레이션
 * 
 * [풀이과정] 
 * 1. 궁수의 위치를 조합으로 정한다. 
 * 2. 조합으로 정한 위치에 궁수를 N행의 적과의 거리를 구한다.
 * 3. 거리가 같은 적이 있을 때 왼쪽먼저 쏜다.
 * 4. 궁수가 1번씩 다 쏘면 N-1행과 비교한다.
 * 5. 궁수가 다쏘면 위로 올려서 계산하자.  
 * N행에 유의 하자
 * [입력]
 * 1 0 1 0 1
 * 0 1 0 1 0
 * 1 1 0 0 0
 * 0 0 0 1 1
 * 1 1 0 1 1
 * 0 0 1 0 0
 * [출력] 14 
 * 
 * @author 
 * @see
 * @performance
 * @category #
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Target {
	int x;
	int y;

	public Target(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

public class Main{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M, D;
	static int[][] field;
	static int[][] backup;
	static int[] selectedIdx = new int[3];
	static boolean[] visited;
	static int result = 0;
	static int max = Integer.MIN_VALUE;

	public static int findDis(int eX, int eY, int aX, int aY) {
		return Math.abs(eX - aX) + Math.abs(eY - aY);
	}

	public static int fightRow2(int archerRow) {
		Target[] archers = new Target[M];
		for (int k = 0; k < M; k++) {
			int minDis = Integer.MAX_VALUE;
			archers[k] = new Target(-1, -1);
			if (field[archerRow][k] == 2) {
				for (int i = archerRow - 1; i >= archerRow - D; i--) {
					if (i < 0)
						break;
					for (int j = 0; j < M; j++) {
						if (field[i][j] == 1) {
							int dis = findDis(i, j, archerRow, k);

							if (dis <= D && minDis > dis) {
								minDis = dis;
								archers[k].setX(i);
								archers[k].setY(j);
							} else if (dis <= D && minDis == dis) {
								if (archers[k].getY() > j) {
									archers[k].setX(i);
									archers[k].setY(j);
								}
							}
						}
					}

				}
			}

		} // archer가 타겟을 다 정함

		for (Target num : archers) {

			if (num.getX() != -1 && num.getY() != -1) {
				if (field[num.getX()][num.getY()] == 1) {
					field[num.getX()][num.getY()] = 0;
					result++;
				}
			}

		}

		return 0;
	}

	public static void fight() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				field[i][j] = backup[i][j];
			}
		}
		int archerRow = field.length - 1;
		for (int i = 0; i < N; i++) {

			fightRow2(archerRow);
			for (int j = 0; j < M; j++) {
				field[archerRow - 1][j] = field[archerRow][j];
			}
			archerRow -= 1;
		}
	}

	public static void select(int cnt, int start) {
		if (cnt == 3) {
			result = 0;
			for (int i = 0; i < M; i++) {
				if (visited[i]) {
					field[field.length - 1][i] = 2;
				} else {
					field[field.length - 1][i] = 0;
				}
			}
			fight();
			if (result > max) {

				max = result;
			}

			return;
		}
		for (int i = start; i < M; i++) {
			if (!visited[i]) {
				selectedIdx[cnt] = i;
				visited[i] = true;
				select(cnt + 1, i + 1);
				visited[i] = false;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());

		field = new int[N + 1][M];
		visited = new boolean[M];

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		backup = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				backup[i][j] = field[i][j];
			}
		}
		select(0, 0);
		output.append(max);
		System.out.println(output);
	}

}
