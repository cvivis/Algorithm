

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static char[] input;
    static Stack<Character> stack = new Stack<>();
    static int result;

    public static void main(String[] args) throws IOException {
       input = br.readLine().toCharArray();
       for(int i = 0; i<input.length;i++){
           if(input[i] == '('){
               stack.push(input[i]);
               result++;
           }
           else{
               stack.pop();
               if(input[i-1] == '('){
                   result--;
                   result += stack.size();
               }

           }
       }
//       System.out.println(Arrays.toString(input));
        System.out.println(result);
    }
}
