

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
    static int N,X;
    static int[] arr;
    static Queue<Integer> window = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        X = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        arr = new int[N];
        int max = 0;
        int sum = 0;
        for(int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        for(int i = 0; i < X;i++){
            window.add(arr[i]);
            sum += arr[i];
        }
        max = sum;
        count = 1;
        for(int i = X; i < N;i++){
            int num = window.poll();
            sum -= num;
            window.add(arr[i]);
            sum += arr[i];
            if(max < sum){
                max = sum;
                count = 1;
            }
            else if(max == sum){
                count++;
            }
        }
        if(max == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
