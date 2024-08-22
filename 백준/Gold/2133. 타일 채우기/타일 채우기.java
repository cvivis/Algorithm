
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        dp = new int[N+1];
        dp[0] = 1;
        if(N>=2){
            dp[2] = 3;
        }
        for(int i = 4; i <= N;i=i+2){
            dp[i] = dp[i-2] * 3;
            for(int j = i;j>=4;j = j-2){
                dp[i] += dp[i-j] * 2;
            }
        }
        System.out.println(dp[N]);
    }
}
