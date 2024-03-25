import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int pair;
    static int[][] arr;
    static boolean[] visited;
    static int count = 0;
    
    public static void dfs(int node) {
    	visited[node] = true;
    	
    	for(int i = 1; i <=N;i++) {
    		if(arr[node][i]==1 && !visited[i]) {
    			dfs(i);
    			count++;
    		}
    	}
    }
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i =0; i < pair;i++) {
			tokens = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		dfs(1);
		System.out.println(count);
	}

}
