

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    // 그냥 N/5하기 <- 실패
    // 10의 개수를 구하기 <- 5 * 2
    // 2는 짝수이면 다 있으니 5의 갯수를 세기 -> N까지의 수중 5의 배수 세기
    // 100은 5가 2개 들어감
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        int count = 0;
        for(int i = 1; i <= N;i++){
            int num = i;
            while(num % 5 == 0){
                count++;
                num = num / 5;
            }
        }
        System.out.println(count);
    }
}
