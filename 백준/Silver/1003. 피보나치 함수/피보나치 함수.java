import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, T;
    static int[][] dp = new int[41][2];

    private static void fibonacci( ){
        for(int i = 2; i <41;i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        T = Integer.parseInt(tokens.nextToken());
        dp[0][0] = 1;
        dp[1][1] = 1;
        fibonacci();
        
        for (int i = 0; i < T; i++) {
            tokens = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokens.nextToken());
            output.append(dp[N][0] + " " + dp[N][1] + "\n");
        }


        System.out.println(output + "\n");
    }


}
