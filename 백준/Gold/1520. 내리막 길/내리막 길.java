
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
DP[a][b] = c 의 의미는 "(a, b)에서는 (N - 1, M - 1) 까지 c개의 경로로 도달할 수 있습니다."

* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] input,dp;
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N][M];
        dp = new int[N][M];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < M;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int i = 0; i < N;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(0,0));
//        for(int[] arr : dp){
//            System.out.println(Arrays.toString(arr));
//        }
    }

    private static int dfs(int x, int y){
        if(x == N-1 && y == M-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i = 0; i< delta.length;i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && input[x][y] > input[nx][ny]){
                dp[x][y] = dp[x][y]+dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
