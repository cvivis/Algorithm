
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 홀수일때는 최댓값을 빼고 나머지에서 작은 값과 큰값을 비교해 MAX비교
// 짝수일때는 가장 큰 값 + 가장 작은값의 쌍중 제일 큰값이 답
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static long[] input;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new long[N];
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            input[i] = Long.parseLong(tokens.nextToken());
        }

        Arrays.sort(input);
        if(N % 2 == 0){
            System.out.println(find(N-1));
        }else{
            if(N == 1){
                System.out.println(input[0]);
            }else{
                System.out.println(Math.max(find(N-2),input[N-1]));
            }
        }
    }
    private static long find(int index){
        long max = 0;
        for(int i = 0; i <(index / 2);i++){
            max = Math.max(max, input[i] + input[index-i]);
        }
        return max;
    }
}
