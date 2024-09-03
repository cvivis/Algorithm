

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static final int NUM = 1000000000;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10][1<<10];
        
        for(int i=1; i<10; i++) {
            dp[1][i][1<<i] =1;
        }


        for(int i = 2; i <= N;i++){
            for(int j = 0; j < 10;j++){
                for(int k = 0; k < (1<<10);k++){
                    if(j == 0){
                        dp[i][j][k | (1<<j)] = (dp[i][j][k | (1<<j)] + dp[i-1][j+1][k]) % NUM;
                    }
                    else if(j == 9){
                        dp[i][j][k | (1<<j)] = (dp[i][j][k | (1<<j)] + dp[i-1][j-1][k]) % NUM;
                    }
                    else{
                        dp[i][j][k|(1<<j)] = (dp[i][j][k | (1<<j)] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % NUM;
                    }
                }

            }
        }
//        for(int[] arr : dp){
//            System.out.println(Arrays.toString(arr));
//        }
        int result = 0;
        for(int i = 0; i < 10;i++){
            result = (result + dp[N][i][(1<<10)-1]) % NUM;
        }
        System.out.println(result);
    }
}
