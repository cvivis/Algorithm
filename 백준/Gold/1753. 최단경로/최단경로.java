/**
 * [키워드]
 * 
 * [풀이과정]
 * 
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
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int V, E;
	static int start;
//	static int[][] input;
	static List<List<Node>> input = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int to;
		int w;

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}

	}

	public static int[] dijktra() {
		int[] dis = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		final int IFN = Integer.MAX_VALUE;
		Arrays.fill(dis, IFN);

		dis[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node head = pq.poll();

			if (visited[head.to]) {
				continue;
			}
			
			visited[head.to] = true;

			
			for (int j = 0; j < input.get(head.to).size(); j++) {
//				if(!visited[j] && input[current][j] != 0 && dis[j] > min+input[current][j]) {
//					dis[j] = min + input[current][j];
//					pq.add(new Node(j,dis[j]));
//				}
//				System.out.println(input.get(current));
				//System.out.println(dis[j]);
				//System.out.println("get: " + input.get(current).get(j));
				//System.out.println("get: " + input.get(current).get(j).w);
				
				Node next = input.get(head.to).get(j);
				if (!visited[next.to] && dis[next.to] > dis[head.to] + next.w) {
					dis[next.to] = dis[head.to] + next.w;
					pq.add(new Node(next.to, dis[next.to]));
				}
			}
//			System.out.println(Arrays.toString(dis));
		}

		return dis;
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		start = Integer.parseInt(br.readLine());
//		input = new int[V+1][V+1];
		for (int i = 0; i <= V; i++) {
			List<Node> list = new ArrayList<>();
			input.add(list);
		}
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
//			input[from][to] = w;
			Node node = new Node(to, w);
			input.get(from).add(node);
//			input.add(list);
		}
//		for (List<Node> list : input) {
//			System.out.println(list);
//		}
//		for(int[] arr : input){
//			System.out.println(Arrays.toString(arr));
//		}
		int[] dis = dijktra();
//		System.out.println(Arrays.toString(dis));
		for (int i = 1; i < dis.length; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dis[i]);
			}

		}
	}

}
