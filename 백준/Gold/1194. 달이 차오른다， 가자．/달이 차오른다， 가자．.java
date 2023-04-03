import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N,M;
	static char[][] input;
	static final int  wall = -1 , escape = 1 , my = -2;
	static final int a = 1 << 1, b = 1 << 2 , c = 1 << 3 , d = 1 << 4 , e = 1 << 5, f = 1 << 6;   
	static Person minsik;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][][] visit;
	static int result = -1 ;
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	
	private static void bfs() {
		Queue<Person> q = new LinkedList<>();
		q.offer(minsik);
		visit[minsik.x][minsik.y][minsik.keys] = true;
		
		
		outer :while(!q.isEmpty()) {
//			System.out.println(q);
//			System.out.println(minsik.keys);
			Person nowLoc = q.poll();
			int x = nowLoc.x;
			int y = nowLoc.y;

			for(int i = 0; i < deltas.length;i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				if(isIn(nx,ny) && input[nx][ny] != '#' && !visit[nx][ny][nowLoc.keys]) {

					
					if(input[nx][ny] == '1') {
						result = nowLoc.dis+1;
						break outer;
					}
					
					
					int nextKeys = nowLoc.keys;
					if("-ABCDEF".indexOf(input[nx][ny]) > 0) {
						int door = "-ABCDEF".indexOf(input[nx][ny]);
						if((nowLoc.keys & 1 << door) <= 0) {
							continue;
						}
					}
					else if("-abcdef".indexOf(input[nx][ny]) > 0) {
						int key = "-abcdef".indexOf(input[nx][ny]);
						nextKeys = nowLoc.keys | 1 << key;
					}
					//input[nx][ny] = '.';
					q.offer(new Person(nx,ny,nextKeys,nowLoc.dis+1));
					visit[nx][ny][nowLoc.keys] = true;	
				}
			}
		}
	}
	
	static class Person{
		int x;
		int y;
		int keys;
		int dis;
		public Person(int x, int y, int keys, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.dis = dis;
		}
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", keys=" + keys + ", dis=" + dis + "]";
		}

		
	}
	
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		input = new char[N][M];
		visit = new boolean[N][M][1 << 7];

		for (int i = 0; i < N; i++) {
			String str  = br.readLine();
			for (int j = 0; j < M; j++) {
				input[i][j] = str.charAt(j);
				if(str.charAt(j) == '0') {
					minsik = new Person(i,j,0,0);
				}		
					
			}
		}		
		bfs();
		
		
		System.out.println(result);
	}
}
