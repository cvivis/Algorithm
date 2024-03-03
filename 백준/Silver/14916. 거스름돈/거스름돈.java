


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        if(N % 5 == 0){
            System.out.println(N / 5);
        }
        else{
            int count = 0;
            while(N % 5 != 0){
                N-= 2;
                count++;
            }
            if(N < 0){
                System.out.println(-1);
            }
           else{
                System.out.println(count + (N / 5));
            }
        }
    }
}
