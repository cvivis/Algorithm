

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (goodWord(str)) result++;
        }
        System.out.println(result);
    }

    private static boolean goodWord(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if(stack.peek() == str.charAt(i)){
                    stack.pop();
                }
                else{
                    stack.push(str.charAt(i));
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
