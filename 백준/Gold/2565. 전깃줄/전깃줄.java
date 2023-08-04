import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] input;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input =new int[N][2];
        dp = new Integer[N];
        for(int i =0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(tokens.nextToken());
            input[i][1] = Integer.parseInt(tokens.nextToken());
        }


        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N ; i++){
            dp[i] = 1;
            for(int j = 0; j < i;j++){
                if(input[j][1] < input[i][1] ){
                    dp[i] = Integer.max(dp[i] , dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(N-dp[N-1]);
    }
}

