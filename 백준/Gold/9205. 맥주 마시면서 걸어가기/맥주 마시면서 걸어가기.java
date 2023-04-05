import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, T;
	static int storeNum;
	static ArrayList<ArrayList<Integer>> a;
	static int festival;
	static Place[] allPlace;
	static boolean[] visit;
	static boolean result;

	static class Place {
		int x;
		int y;

		@Override
		public String toString() {
			return "place [x=" + x + ", y=" + y + "]";
		}

		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	private static void dfs(int num,int count) {
//		System.out.println("num: "+num + " "+ festival);
		if(num == festival-1) {
			result = true;
			return;
		}
		
		ArrayList<Integer> list = a.get(num);
		for(int i = 0; i < list.size();i++) {
			if(!visit[list.get(i)]) {
				visit[list.get(i)] = true;
				dfs(list.get(i),count+1);
//				visit[list.get(i)] = false;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			storeNum = Integer.parseInt(br.readLine());
			a = new ArrayList<>();
			festival = storeNum+2;
			visit = new boolean[festival];
			allPlace = new Place[festival];
			result = false;
			for(int i = 0; i < festival;i++) {
				a.add(new ArrayList<>());
			}
			
			for (int i = 0; i < festival; i++) {
				tokens = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				allPlace[i] = new Place(x,y);
			}
			
			for(int i = 0; i < allPlace.length;i++) {
				for(int j = 0; j < allPlace.length;j++) {
					if(i == j) continue;
					int dis = Math.abs(allPlace[i].x - allPlace[j].x) + Math.abs(allPlace[i].y - allPlace[j].y );
					if(dis <= 1000) {
						if(a.get(i).indexOf(j) < 0) {
							a.get(i).add(j);
						}

					}
				}
			}
			
			
//			for(ArrayList<Integer> list : a) {
//				System.out.println(list);
//			}
			visit[0] = true;
			dfs(0,0);
			
			if(result) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
			
			
//			System.out.println("asd");
//			for(ArrayList list : a) {
//				System.out.println(list);
//			}
			
		}

	}
}
