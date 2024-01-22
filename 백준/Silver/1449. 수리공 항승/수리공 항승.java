import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,L;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        L = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            pq.add(Integer.parseInt(tokens.nextToken()));
        }
        int cnt = 1;
        int now = pq.peek();
        while(!pq.isEmpty()){
            if(pq.peek() <= now+L-1){
                pq.poll();
            }
            else{
                now = pq.peek();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
