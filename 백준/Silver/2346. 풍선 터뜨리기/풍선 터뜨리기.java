

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


//ArrayDeque
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] input;
    static ArrayDeque<Balloon> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = new int[N+1];

        tokens = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N;i++){
            int num = Integer.parseInt(tokens.nextToken());
            input[i] = num;
        }
        for(int i = 2 ; i <= N;i++){
            queue.offer(new Balloon(i,input[i]));
        }
        int num = 1;
        int next = input[1];
        output.append(num+" ");
        while(!queue.isEmpty()){
            Balloon balloon;
            if(next>0){
                plusFind(next-1);
                balloon = queue.poll();
                output.append(balloon.num+" ");
            }
            else{
                minusFind(next*(-1)-1);
                balloon = queue.pollLast();
                output.append(balloon.num+" ");
            }
            next = balloon.next;
        }
        System.out.println(output);
    }
    private static class Balloon{
        int num;
        int next;

        public Balloon(int num, int next) {
            this.num = num;
            this.next = next;
        }
    }
    private static void minusFind(int num){

        for(int i = 0 ; i < num;i++){
            queue.addFirst(queue.pollLast());
        }
    }
    private static void plusFind(int num){
        for(int i = 0 ; i < num;i++){
            queue.addLast(queue.pollFirst());
        }
    }

}
