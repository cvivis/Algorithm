import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            String input = br.readLine();
            boolean result = check(input);
            if(result) System.out.println("YES");
            else{
                System.out.println("NO");
            }
        }
    }

    private static boolean check(String input){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < input.length();i++){
            char c = input.charAt(i);
            if(c == ')'){
                Character pop = stack.pollLast();
                if(pop== null || pop != '(')return false;
            }
            else{
                stack.addLast(c);
            }
        }
        if(!stack.isEmpty())return false;
        return true;
    }
}
