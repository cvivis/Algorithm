

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, T, target;
    static int[] coins;
    // coin종류가 정렬되서 나옴 -> 작은거 부터 먼저 세야 전체 다 셀 수 있음
    static int[][] dp; // (5 , 7로 60만들기 5가 12개 (5+7)이 5개) -> 따라서 동전 종류 별도로 저장해야함

    // knapsack처럼 작은 동전부터 가능한 금액에 + 다음 동전의 금액
    /*
1
2
1 2
1000
    * */
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        T = Integer.parseInt(tokens.nextToken());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N + 1];
            tokens = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(tokens.nextToken());
            }
            target = Integer.parseInt(br.readLine());
            dp = new int[N + 1][target + 1];
            for(int i = 1; i < coins.length;i++){
                dp[i][0] = 1;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j <= target; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - coins[i] >= 0 && dp[i][j - coins[i]] > 0) {
                        dp[i][j] +=  dp[i][j - coins[i]] ;
                    }

                }
            }
            System.out.println(dp[N][target]);
//            for (int[] arr : dp) {
//                System.out.println(Arrays.toString(arr));
//            }
        }

    }

}
