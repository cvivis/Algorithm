/**
 * [키워드] dfs, 완전탐색
 * 
 * [풀이과정]
 * - visited를 이용해 방문 요소 확인
 * - 인접 행렬은 시간초과가 난다.
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
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static int[][] friendR;
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static boolean check = false;
	static int result = 0;

	public static void find(int num, int count) {
		if (check)
			return;
		if (count >= 5) {
			check = true;
			return;
		}
//		System.out.println(num);
		for (int i = 0; i <  list.get(num).size(); i++) {
			if (!list.get(num).isEmpty()) {
//				System.out.println(list.get(num));
				int next = list.get(num).get(i);
//				System.out.println("next"+next);
//				System.out.println();
				if (!visited[next]) {
					visited[next] = true;
					find(next, count + 1);
					visited[next] = false;
				}

			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		friendR = new int[N][N];
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
//			friendR[a][b] = 1;
//			friendR[b][a] = 1;
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
//		for(int i = 0 ; i < list.size();i++) {
//			for(int j = 0; j < list.get(i).size();j++) {
//				System.out.print(list.get(i).get(j)+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println("++++++++++++");

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			find(i, 1);
			if (check) {
				result = 1;
				break;
			}
//			System.out.println("------------");
		}

		output.append(result);
		System.out.println(output);
	}

}
