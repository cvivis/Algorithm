

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N;i++){
//            System.out.println(deque);
            tokens = new StringTokenizer(br.readLine());
            String command = tokens.nextToken();
            if(command.equals("push_front")){
                int num = Integer.parseInt(tokens.nextToken());
                deque.addFirst(num);
            }
            else if(command.equals("push_back")){
                int num = Integer.parseInt(tokens.nextToken());
                deque.addLast(num);
            }
            else if(command.equals("pop_front")){
                if(deque.isEmpty()){
                    output.append("-1\n");
                }else{
                    output.append(deque.pollFirst()+"\n");
                }
            }
            else if(command.equals("pop_back")){
                if(deque.isEmpty()){
                    output.append("-1\n");
                }
                else{
                    output.append(deque.pollLast()+"\n");
                }
            }
            else if(command.equals("size")){
                output.append(deque.size()+"\n");
            }
            else if(command.equals("empty")){
                if(deque.isEmpty()){
                    output.append("1\n");
                }else{
                    output.append("0\n");
                }
            }
            else if(command.equals("front")){
                if(deque.isEmpty()){
                    output.append("-1\n");
                }else{
                    output.append(deque.peek()+"\n");
                }
            }
            else if(command.equals("back")){
                if(deque.isEmpty()){
                    output.append("-1\n");
                }else{
                    output.append(deque.peekLast()+"\n");
                }
            }
        }
        System.out.println(output);
    }
}
