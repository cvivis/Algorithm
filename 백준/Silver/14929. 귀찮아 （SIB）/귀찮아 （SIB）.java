

import java.util.*;
import java.io.*;
/*
1 -2 3
-2, 3 , -6 = -5
모든 2개의 곱 한 수들의 합 구하기
n = 100000 -> O(최대 NlogN)
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer tokens;
    static int[] input,sum;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        input = new int[N+1];
        sum = new int[N+1];
        for(int i = 1; i <= N;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        sum[1] = input[1];
        for(int i = 1; i <= N;i++){
            sum[i] = sum[i-1] + input[i];
        }

        long result = 0;
        for(int i = 1; i <= N-1;i++){
            result += (long)input[i] * (sum[N] - sum[i]);
//            System.out.println(result);
        }
        System.out.println(result);
    }
}
