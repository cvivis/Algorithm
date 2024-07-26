

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] T,P;
    static int[] D;


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        T = new int[N+1];
        P = new int[N+1];
        D = new int[N+2];
        for(int i = 1; i <= N;i++){
            tokens = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(tokens.nextToken());
            int p = Integer.parseInt(tokens.nextToken());
            T[i] = t;
            P[i] = p;
        }
        int max = 0;
        for(int i = 1; i <= N;i++){
            max = Math.max(max,D[i]);
            if(T[i] + i <= N+1){
                D[i] = Math.max(max + P[i],D[i]+P[i]);
                D[i + T[i]] = Math.max(D[i],D[i + T[i]]);

            }
        }
//        System.out.println(Arrays.toString(D));
        Arrays.sort(D);
        System.out.println(D[N]);
    }
}
