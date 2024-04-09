import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//D[i-2] 중 세로 2개 세운부분이 D[i-1]에 포함된다
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] D;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        D = new int[N+1];
        D[1] = 1;
        if(N >= 2){
            D[2] = 3;
        }

        for(int i = 3; i <= N; i++){
            D[i] = (D[i-2] * 2 + D[i-1])%10007;
        }
        System.out.println(D[N]);

    }
}
