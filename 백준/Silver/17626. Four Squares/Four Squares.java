

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] dp;
    //1~223까지
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        dp = new int[50001];
        dp[1] = 1;
        for(int i = 2; i <= N;i++){
            dp[i] = dp[i-1]+1;
            for(int j = 1; j * j <= i;j++){
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        System.out.println(dp[N]);
    }

}
