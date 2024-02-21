

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] input;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        for(int i = 0; i < N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        int num = 1;
        int arrIdx = 0;
        while(arrIdx<input.length && num <= N){
            if(stack.empty()){
                stack.push(num);
                num++;
                output.append("+\n");
            }
            else{
                int top = stack.peek();
                if(top == input[arrIdx]){
                    stack.pop();
                    arrIdx++;
                    output.append("-\n");
                }
                else{
                    if(top<input[arrIdx]){
                        stack.push(num);
                        num++;
                        output.append("+\n");
                    }else{
                        break;
                    }
                }
            }
        }
//        System.out.println(stack);
//        System.out.println(input[arrIdx]);
        for(int i = stack.size();i>=0 ;i--){
//            System.out.println(stack.peek() + " "+ input[arrIdx]);
                if(stack.peek() == input[arrIdx]){
                    output.append("-\n");
                    stack.pop();
                    if(stack.empty())break;
                    arrIdx++;
                }
                else{
                    output.setLength(0);
                    output.append("NO");
                    break;
                }
        }
        System.out.println(output);
    }
}
