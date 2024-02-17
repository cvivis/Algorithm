

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int big, small;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        int fiveDegree = findDegree(N,5) - findDegree(N-M,5) - findDegree(M,5);
        int twoDegree = findDegree(N,2) - findDegree(N-M,2) - findDegree(M,2);
        System.out.println(Math.min(fiveDegree,twoDegree));
    }
    private static int findDegree(int n, int m){
        int count = 0;
        while(n >= m){
            count += n / m;
            n = n / m;
        }
        return count;
    }
}

