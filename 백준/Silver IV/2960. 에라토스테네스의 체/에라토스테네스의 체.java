
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static boolean[] table;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        table = new boolean[N+1];
        System.out.println(eratosthenes());
    }
    private static int eratosthenes(){
        for(int i = 2; i  <= N;i++ ){ // 소수자체도 세야하기 때문에 i*i 범위는 합성수만 체크할 때 사용가능
            int mul = 1; //소수자체도 세야함
            int num = i;
            while(num * mul <= N){ // 배수 체크
                if(!table[num * mul]){
                    table[num * mul] = true;
                    count++;
                    if(count == K){
                        return num * mul;
                    }
                }
                mul++;
            }
        }
        return 0;
    }
}
