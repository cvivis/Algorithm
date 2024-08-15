
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
4 4
0000
0110
0110
0000

4 4
1100
1100
0000
0000

4 4 (3%)
0100
0111
1111
0111

4 4
0000
0000
0000
0000

4 4
1111
1111
1111
1111

4 4
1111
1001
1001
1111

4 4
1100
1100
0011
0011

4 5
11000
11100
01111
00111

3 3
000
010
000

3 3 (34%)
000
000
100
* */
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
        dp = new int[N][M]; // ,i,j를 오른쪽 아래 꼭지점으로 두는 정사각형의 최대 크기
        int max = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(str.charAt(j) + "");
                max = Math.max(max,dp[i][j]);
            }
        }

        for(int i = 0; i < N;i++){
            for(int j = 0; j < M;j++){
                if(dp[i][j] == 1 && i-1>= 0 && j-1 >= 0){
                    int left = dp[i][j-1];
                    int top = dp[i-1][j];
                    int side = dp[i-1][j-1];
                    int min = Math.min(left,top);
                    min = Math.min(min,side);
                    dp[i][j] = min+1;
                    if(max < dp[i][j])max = dp[i][j];
                }
            }
        }
        System.out.println(max * max);
    }
}
