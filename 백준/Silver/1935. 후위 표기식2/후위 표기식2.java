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
    static Stack<Double> stack = new Stack<>();
    static int[] nums;
    static final char PLUS = '+' , MINUS = '-' , MUL = '*', DIV = '/';

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        String input = br.readLine();
        nums = new int[N];
        for(int i = 0; i < N;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        double ans = 0;
        for(int i = 0; i < input.length();i++){
            char num = input.charAt(i);
            if((num == PLUS) || (num == MINUS) || (num == MUL) || (num==DIV)){
                double second = stack.pop();
                double first = stack.pop();
                double result = operate(first, second, num);
                stack.push(result);
                ans = result;
            }
            else{
                int idx = num - 'A';
                stack.push(Double.parseDouble(nums[idx]+""));
            }
        }

        System.out.printf("%.2f",ans);
    }
    private static double operate(double first , double second , char operation){
        if(operation == PLUS) return first + second;
        else if(operation == MINUS) return first - second;
        else if(operation == MUL) return first * second;
        else {
            return first / second;
        }
    }
}
