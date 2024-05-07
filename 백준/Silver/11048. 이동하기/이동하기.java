

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//bfs로 풀기에는 최단이 아니기 때문에 O(N^2)를 초과하여 큐에 넣을 수 있음
// 방향이 3 방향이기 고정 때문에 DP가 맞는
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] dp,input;
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
        dp[0][0] = input[0][0];
        for(int i = 0; i < N;i++){
            for(int j = 0; j < M;j++){
                if(i == 0){
                    if(j == 0)continue;
                    dp[i][j] = dp[i][j-1] + input[i][j];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j] + input[i][j];
                }
                else{
                    int max = Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.max(max,dp[i-1][j-1]) + input[i][j];
                }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
