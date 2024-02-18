import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            String[] command = bf.readLine().split(" ");
            if(command[0].equals("push")){
                stack.push(command[1]);
            }
            else if(command[0].equals("pop")){
                if(stack.size()==0){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.pop());
                }
            }
            else if(command[0].equals("top")){
                if(stack.empty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.peek());
                }
            }
            else if(command[0].equals("size")){
                System.out.println(stack.size());
            }
            else if(command[0].equals("empty")){
                if(stack.empty()==true){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
}
