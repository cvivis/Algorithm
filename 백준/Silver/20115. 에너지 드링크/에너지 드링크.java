

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
    static int[] input;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i = 0; i < N;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(input);
        double sum = input[input.length-1];
        for(int i = 0; i < input.length-1;i++){
            sum += input[i]/2.0;
        }
        System.out.println(sum);
    }
}
