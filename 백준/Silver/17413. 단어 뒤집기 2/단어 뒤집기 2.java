

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
    static String input;
    static Stack<Character> stack = new Stack<>();
    static final Character OPEN = '<' , CLOSE = '>';

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        boolean trigger = false;
        StringBuilder reverse = new StringBuilder();
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) == OPEN || input.charAt(i) == CLOSE){
                if(reverse.length()>=1){
                    output.append(reverse);
                    reverse.setLength(0);
                }
                output.append(input.charAt(i));
                trigger = !trigger;

            }else{
                if(trigger){
                    output.append(input.charAt(i));
                }
                else if(!trigger){
                    if(input.charAt(i) != ' '){
                        reverse.insert(0,input.charAt(i));
                    }
                    else{
                        output.append(reverse+" ");
                        reverse.setLength(0);
                    }
                }
            }
        }
        if(reverse.length()>=1){
           output.append(reverse);
            reverse.setLength(0);
        }
        System.out.println(output);
    }
}
