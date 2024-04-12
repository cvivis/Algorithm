

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static long[][] d;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        d = new long[101][10];
        for(int i = 1; i <= 9;i++){
            d[1][i] = 1;
        }

        for(int i = 2;i <= 100;i++){
           for(int j = 0; j <= 9;j++){
               if(j >= 1 && j <= 8){
                   d[i][j] = (d[i-1][j-1]  + d[i-1][j+1]) % 1000000000 ;

               }
               else if(j == 0){
                   d[i][j] = d[i-1][1] % 1000000000;
               }
               else if(j == 9){
                   d[i][j] = d[i-1][8] % 1000000000;
               }
           }
        }
        long cnt = 0;
        for(int i = 0; i <= 9;i++){
            cnt += d[N][i];
        }
        System.out.println(cnt % 1000000000);
    }
}
