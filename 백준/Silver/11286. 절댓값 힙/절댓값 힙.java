import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int absO1 = Math.abs(o1);
            int absO2 = Math.abs(o2);
            if(absO1 == absO2){
                return o1 - o2;
            }
            else{
                return absO1 - absO2;
            }
        }
    });


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++) {
            int ans = Integer.parseInt(br.readLine());
            int result = 0;
            if(ans == 0){
                if(!pq.isEmpty()){
                    result = pq.poll();
                }
                output.append(result+"\n");
            }
            else{
                pq.add(ans);
            }

        }
        System.out.println(output);
    }
}
