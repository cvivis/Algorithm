

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static boolean[] table;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        table = new boolean[N+1];
        System.out.println(eratosthenes());
    }
    private static int eratosthenes(){
        for(int i = 2; i  <= N;i++ ){
            int mul = 1;
            int num = i;
            while(num * mul <= N){
                if(!table[num * mul]){
//                    System.out.println(num * mul);
                    table[num * mul] = true;
                    count++;
                    if(count == K){
//                        System.out.println(num * mul +" asdf");
                        return num * mul;
                    }
                }
                mul++;
            }
        }
        return 0;
    }
}
