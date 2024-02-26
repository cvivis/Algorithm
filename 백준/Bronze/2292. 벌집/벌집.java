

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1 -> 7 -> 18... 각각의 까지 1개, 2개 ,3개
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        int num = 1;
        int count = 1;
        while(num < N){
            num = num + 6 * count;
            count++;
        }
        System.out.println(count);
    }
}
