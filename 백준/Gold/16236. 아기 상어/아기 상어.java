/**
 * [키워드]
 * 
 * [풀이과정]
 * 1. 상어 위치에서 모든 물고기까지의 거리 구하기
 * 	- 거리는 BFS로 input테이블에서 크기가 크면 못지나가도록 사방 탐색하며 거리 구하기   
 * 2. 우선순위 큐 그때마다 돌려서 제일 앞의 물고기 꺼내기
 * 3. 그 물고기를 먹을 수 있는지 판별하기 
 * 4. 먹을 수 있으면 그 물고기 까지의 거리를 time에 더하기 
 * 	- 먹고 상어의 크기를 실시간 반영하여 물고기 먹을 수 있는지 여부 갱신하기. 
 * 5. 안되면 엄마 부르기 
 * [입력]
 * [출력] 
 * 
 * @author 
 * @see
 * @performance
 * @category #
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class BabyShark {
	int x;
	int y;
	int size;
	int eatCount;
	int time;

	public BabyShark(int x, int y, int size, int eatCount, int time) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.eatCount = eatCount;
		this.time = time;
	}

	@Override
	public String toString() {
		return "BabyShark [x=" + x + ", y=" + y + ", size=" + size + ", eatCount=" + eatCount + ", time=" + time + "]";
	}

}

class Fish implements Comparable<Fish> {
	int x;
	int y;
	int size;
	int dist;

	public Fish(int x, int y, int size, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", size=" + size + ", dist=" + dist + "]";
	}

	@Override
	public int compareTo(Fish o) {
		// TODO Auto-generated method stub
		if (this.dist == o.dist) {
			if (this.x == o.x) {
				if (this.y == o.y) {
					return Integer.compare(this.size, o.size);
				} else {
					return Integer.compare(this.y, o.y);
				}

			} else {
				return Integer.compare(this.x, o.x);
			}
		}

		return Integer.compare(this.dist, o.dist);
	}

}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[][] input;
	static PriorityQueue<Fish> fishs;
	static BabyShark babyShark;
	static int time = 0;
	final static int INF = Integer.MAX_VALUE;

	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	static void findNextFish() {
		PriorityQueue<Fish> temp = new PriorityQueue<>();
		while (!fishs.isEmpty()) {
			temp.add(fishs.poll());
		}
		fishs = new PriorityQueue<>();
		while (!temp.isEmpty()) {
			fishs.add(temp.poll());
		}

	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(tokens.nextToken());
				if (input[i][j] == 9) {
					babyShark = new BabyShark(i, j, 2, 0, 0);
				}
			}
		}
		fishs = new PriorityQueue<>();
		findNextFish();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (input[i][j] >= 1 && input[i][j] <= 6) {
					Fish fish = new Fish(i, j, input[i][j], 0);
					int dist = calDist(fish);
					fish.dist = dist;
					fishs.add(fish);
				}
			}
		}


		moveShark();
		System.out.println(babyShark.time);
	}

	static class Node {
		int x;
		int y;
		int dis;

		public Node(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dis=" + dis + "]";
		}

	}

	static void moveShark() {	
		while (!fishs.isEmpty()) {
			Fish eatenFish = fishs.poll();
			if (eatenFish.dist != INF) {
				input[babyShark.x][babyShark.y] = 0;
				babyShark.x = eatenFish.x;
				babyShark.y = eatenFish.y;
				input[babyShark.x][babyShark.y] = 9;
				babyShark.time += eatenFish.dist;

				if (++babyShark.eatCount == babyShark.size) {
					babyShark.size++;
					babyShark.eatCount = 0;
				}
				for (Fish fish : fishs) {
					int dis = calDist(fish);
					fish.dist = dis;
				}

				findNextFish();

			} else {
				break;
			}
		}

	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static int calDist(Fish fish) { // 물고기와 상어 거리
		Queue<Node> queue = new LinkedList<>();

		boolean[][] visited = new boolean[N][N];
		visited[babyShark.x][babyShark.y] = true;
		queue.add(new Node(babyShark.x, babyShark.y, 0));
		Node node = null;
		while (!queue.isEmpty()) {

			node = queue.poll();
			if (node.x == fish.x && node.y == fish.y)
				break;
			for (int i = 0; i < 4; i++) {
				int nx = node.x + deltas[i][0];
				int ny = node.y + deltas[i][1];

				if (isIn(nx, ny) && !visited[nx][ny] && input[nx][ny] <= babyShark.size) {

					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, node.dis + 1));
				}
			}
		}

		if (node.x != fish.x || node.y != fish.y || fish.size >= babyShark.size) {

			return INF;
		} else {
			return node.dis;
		}

	}

}