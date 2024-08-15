

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
4%
10
1 1 1 1 1 1 1 1 1 1 1
10
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
9 10
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] input;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        input = new int[N+1];
        for(int i = 1; i<=N;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        dp = new int[N+1][N+1];
        for(int i = 1; i <= N;i++){
            dp[i][i] = 1;
            if(i+1<=N && input[i] == input[i+1]){
                dp[i][i+1] = 1;
            }
        }
        for(int i = N; i >=1;i--){
            for(int j = N; j >= 1;j--){
                if(input[i] == input[j] && i+1 <= N && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
            }
        }


        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M;i++){
            tokens = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());
            output.append(dp[s][e]+"\n");
        }
//        for(int[] arr : dp){
//            System.out.println(Arrays.toString(arr));
//        }
        System.out.println(output);
    }
}
