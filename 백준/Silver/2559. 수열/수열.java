

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static int[] arr;
    static Queue<Integer> window = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        arr = new int[N];
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        int sum = 0;
        for(int i = 0; i < K;i++){
            window.add(arr[i]);
            sum += arr[i];
        }
        int max = sum;
        for(int i = K;i<N;i++){
            sum -= window.poll();
            window.add(arr[i]);
            sum+=arr[i];
            if(max < sum){
                max = sum;
            }
        }
        System.out.println(max);

    }

}
