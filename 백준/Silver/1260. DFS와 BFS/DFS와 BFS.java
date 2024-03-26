

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Queue<Integer> queue = new LinkedList<>();
	static int[][] arr;
	static int N;
	static int M;
	static int V;
	static boolean[] checked;

	public static void bfs(int start) {
		queue.add(start);
		checked[start] = true;
		while(!queue.isEmpty()) {
			start = queue.poll();
			output.append(start).append(" ");
			for(int i = 1; i<=N;i++) {
				if(arr[start][i] == 1 && !checked[i]) {
					queue.add(i);
					checked[i] = true;
				}
			}
		}
		System.out.println(output);
	}
	
	public static void dfs(int start) {
		checked[start] = true;
		output.append(start).append(" ");
		for(int i = 1; i <= N;i++) {
			if(arr[start][i] == 1 && !checked[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());

		arr = new int[N + 1][N + 1];
		checked = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		dfs(V);
		output.append("\n");
		checked = new boolean[N + 1];
		bfs(V);
	}

}
