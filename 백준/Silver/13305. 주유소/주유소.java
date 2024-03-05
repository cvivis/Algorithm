
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나보다 싼게 나올때까지 구매하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] dis;
    static int[] fuel;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        dis = new int[N-1];
        fuel = new int[N];
        for(int i = 0 ; i < dis.length;i++){
            dis[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < fuel.length;i++){
            fuel[i] = Integer.parseInt(tokens.nextToken());
        }
        int cost = 0;
        for(int i = 0; i < fuel.length-1;i++){
//            System.out.println(i+" i ");
            int disSum = dis[i];
            int next = i+1;
            while(fuel[i] < fuel[next] && next < fuel.length-1){
                disSum+=dis[next];
                next++;
            }
//            System.out.println(cost);
            cost += (fuel[i] * disSum);
            i = next-1;
        }
        System.out.println(cost);
    }
}
