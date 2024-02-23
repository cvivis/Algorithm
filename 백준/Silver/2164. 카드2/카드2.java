

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (queue.size() >= 1) {
            if (queue.size() == 1){
                break;
            }
            queue.poll();
            if (queue.size() == 1){
                break;
            }
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
