

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 ){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        int sum = 0;
        for(int i : stack){
            sum += i;
        }
        System.out.println(sum);
    }
}

