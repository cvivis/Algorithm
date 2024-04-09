

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static int[] coin, D;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        coin = new int[N];
        D = new int[K+1]; // 가치가 k인 경우의 수
        for(int i = 0 ; i < N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        D[0] = 1;
        for(int i = 0 ; i < coin.length;i++){
            for(int j = 1; j < D.length;j++){
                if(j - coin[i] >= 0){
//                    System.out.println(j);
//                    System.out.println(j - coin[i]);
                    D[j] = D[j] + D[j - coin[i]];
                }
            }
        }
        System.out.println(D[K]);
    }
}
