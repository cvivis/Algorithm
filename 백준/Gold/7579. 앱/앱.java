import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리초과 -> 배열에 배터리 메모리를 넣지 말고 코스트를 넣자
//dp[i][c] -> 코스트가 c일때 최소 메모리
/*
7 120
20 91 92 93 94 95 100
1 2 2 2 2 2 2
-> 3
* */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] memory , cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        memory = new int[N];
        cost = new int[N];
        dp = new int[N][10001];
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            memory[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            cost[i] = Integer.parseInt(tokens.nextToken());
        }
//        for(int i = 0; i < dp.length;i++){
//            Arrays.fill(dp[i],-1);
//        }
        dp[0][cost[0]] = memory[0];
        for(int i = 1; i < N;i++){
//            dp[i-1][cost[i-1]] = Math.max(memory[i-1],dp[i-1][cost[i-1]]);
            for(int j = 0; j < dp[i].length;j++){
//                if(dp[i-1][j] != 0){
//                    System.out.println(dp[i-1][j] + " 확인중 ");
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if(j-cost[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-cost[i]] + memory[i]);
                }
                
            }
//            for(int[] arr : dp){
//                System.out.println(Arrays.toString(arr));
//            }
//            System.out.println("-----------------");
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < dp[N-1].length;i++){
            if(dp[N-1][i]>=M){
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}
