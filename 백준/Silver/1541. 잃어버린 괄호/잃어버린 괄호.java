import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/*
* 1. - 올때마다 뒤에 식은 모두 묶어서 더하기
* 2. - 올때마다 앞에 저장하던 수식 계산하기 
* 2-1. 앞에 연산이 + 면 더하고 - 면 빼기
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static String number = "0123456789";
    static char flus = '+';
    static char minus = '-';
    static int result = 0;

    private static int flusCal(String expression) {
        String num = "";
        int result = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == flus) {
                result += Integer.parseInt(num);
                num = "";
            } else {
                num += c;
            }
        }
        result += Integer.parseInt(num);
        return result;
    }

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String expression = "";
        char preSign = flus;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != minus) {
                expression += c;
            } else {
                if(preSign == flus){
                    result += flusCal(expression);
                    preSign = minus;
                    expression = "";
                }else{
                    result -= flusCal(expression);
                    expression = "";
                }
            }
        }
        if(preSign == flus){
            result += flusCal(expression);
        }else{
            result -= flusCal(expression);
        }
        System.out.println(result);
    }
}
