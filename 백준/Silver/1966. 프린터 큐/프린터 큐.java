
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,T,M;
    static Queue<Docs> queue;
    static Integer[] priorities;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T;i++){
            tokens = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            priorities = new Integer[N];
            tokens = new StringTokenizer(br.readLine());
            queue = new ArrayDeque<>();
            for(int j = 0 ; j < N;j++){
                int priority = Integer.parseInt(tokens.nextToken());
                queue.offer(new Docs(j,priority));
                priorities[j] = priority;
            }
            Arrays.sort(priorities, Collections.reverseOrder());
            System.out.println(printQueue());
        }
    }
    private static class Docs{
        int idx;
        int priority;

        public Docs(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Docs{" +
                    "idx=" + idx +
                    ", priority=" + priority +
                    '}';
        }
    }
    private static int printQueue(){
        int max = priorities[0];
        int count = 0;
//        System.out.println(queue);
        while(!queue.isEmpty()){
//            System.out.println(queue);
            Docs now = queue.poll();
//            System.out.println(now.priority + " "+max);
            if(now.priority==max){

                count++;
                if(now.idx == M){
                    break;
                }
                max = priorities[count];


            }
            else{
                queue.offer(now);
            }
        }
        return count;
    }
}
