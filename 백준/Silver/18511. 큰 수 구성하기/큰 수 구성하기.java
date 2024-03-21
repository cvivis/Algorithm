
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static int[] input;
    static int max = Integer.MIN_VALUE;
    static int len = 0;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        input = new int[K];
        for(int i = 0; i<K;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        int n = N;
        while(n > 9){
            n/=10;
            len++;
        }
        len++;
        find(0,0,"");
        System.out.println(max);
    }
    private static void find(int cnt, int idx,String num){
//        System.out.println(num);
        if(cnt <= len){
            if(num.length() >0){
                int n = Integer.parseInt(num);
                if(max < n && n <= N){
                    max = n;
                }
            }
        }else{
            return;
        }
        for(int i = 0;i<input.length;i++){
            find(cnt + 1,i,num+input[i]);
        }
    }
}
