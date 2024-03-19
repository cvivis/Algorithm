
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 100C3
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static int[] input;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i = 0; i < N;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        find(0,0,0);
        System.out.println(M-min);
    }
    private static void find(int cnt, int sum,int idx){
        if(cnt == 3){
            if(M-sum >= 0 && M - sum < min){
                min = M-sum;
            }
            return;
        }
        for(int i = idx; i < input.length;i++){
            find(cnt+1,sum+input[i],i+1);
        }
    }
}
