

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();

    // a 와 b 중 더 큰 값이 a일때, a = b * 몫 + 나머지
    // 유클리드 호제법에서 GCD(a,b) = GCD(b,나머지) 
    // GCD(a,0) = a
    public static int maxDivisor(int a, int b) {// GCD 유클리드 호제법 int a 가 큰수
        int remain;
        int numA = a;
        int numB = b;
        while (true) {
            remain = numA % numB;
            if (remain == 0)
                break;
            numA = numB;
            numB = remain;
        }
        return numB;
    }

    // 최소 공배수 정의대로
    // a * c = b * d = 최소공배수
    // c를 1부터 확인해서 b로 나누었을때 0이 되는값이 최소공배수
    public static int minMultiple(int a, int b) {
        int count = 1;
        while (true) {
            if ((a * count % b) == 0) {
                break;
            }
            count++;
        }

        return a * count;
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        System.out.println(maxDivisor(Math.max(N, K), Math.min(N, K)));
        System.out.println(minMultiple(N, K));

//		System.out.println(Arrays.toString(eratostenes(N)));

    }
}
