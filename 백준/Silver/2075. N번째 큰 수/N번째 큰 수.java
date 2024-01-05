import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0 ; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < N;j++)
            {
                int num = Integer.parseInt(tokens.nextToken());
                pq.add(num);
            }
        }
        for(int i = 0 ; i < N-1;i++){
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}
