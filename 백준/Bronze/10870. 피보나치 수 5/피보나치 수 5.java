

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        if(N == 1){
            result = 1;
        }
        else if(N == 0){
            result = 0;
        }
        else{
            find(0,0,1);
        }
        System.out.println(result);

    }
    private static void find(int cnt,int f1, int f2){
        if(cnt == N){
            result = f1;
            return;
        }
        find(cnt + 1, f1 + f2, f1);
    }
}
