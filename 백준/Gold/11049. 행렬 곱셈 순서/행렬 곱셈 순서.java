

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
- dp[i][j]을 채우기 위해선 그 아래와 왼쪽이 모두 채워져 있어야함
- i==i일때부터 i와 j의 간격이 +1씩 느는 대각선 방향으로 칸을 채운다.
- dp[i][j] = dp[i][k] + dp[k+1][j] + i,j매트릭스 연산횟수 이때 k는 i<=k k < j 인 수

* */



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] matrix,dp;

    // 대각선으로 채워지는 양상이기 때문에 반복문 돌리는 것을 고민해야함
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        matrix = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for(int i = 1;i <= N;i++){
            tokens = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(tokens.nextToken());
            int c = Integer.parseInt(tokens.nextToken());
            matrix[i][0] = r;
            matrix[i][1] = c;
        }
        for(int i = 1; i <= N;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for(int i = 1; i < N; i++){ //간격
            for(int j = 1; j <= N-i;j++){ // 시작좌표는 N-간격까지  됨
                int end = i + j;
                for(int k = j; k < end;k++) {
                    int num = dp[j][k] + dp[k+1][end] + (matrix[j][0] * matrix[k][1] * matrix[end][1]);
                    dp[j][end] = Math.min(dp[j][end],num);
                }
            }
        }
//        for(int[] arr : dp){
//            System.out.println(Arrays.toString(arr));
//        }
        System.out.println(dp[1][N]);
    }
}
