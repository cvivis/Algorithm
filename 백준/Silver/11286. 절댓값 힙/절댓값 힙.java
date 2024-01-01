
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static PriorityQueue<Integer> plusPq = new PriorityQueue<>();
    static PriorityQueue<Integer> minusPq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            int ans = Integer.parseInt(br.readLine());
            if(ans == 0) {
                int result = 0;
                if(plusPq.isEmpty() && minusPq.isEmpty()){
                    result = 0;
                }
                else if(!plusPq.isEmpty() && !minusPq.isEmpty()){
                    int plus = plusPq.peek();
                    int minus = minusPq.peek();
                    if(plus < minus){
                        result = plusPq.poll() ;
                    }
                    else if(plus >= minus){
                        result = minusPq.poll() * -1;
                    }
                }
                else if (!plusPq.isEmpty()) {
                    result = plusPq.poll();
                }
                else if (!minusPq.isEmpty()) {
                    result = minusPq.poll() * -1;
                }
                output.append(result + "\n");

            }
            else if(ans > 0 ){
                plusPq.add(ans);
            }
            else{
                minusPq.add(ans * -1);
            }
        }
        System.out.println(output);
    }
}
