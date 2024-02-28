

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    /*
    [A-F]? : A~F 중 문자가 있거나 없다
    A+ : A가 1문자이상 있다.
    $ : 문자열이 끝난다.
    *
    * */
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        String regex = "[A-F]?A+F+C+[A-F]?$";

        for(int i=0;i<N;i++) {
            String word = br.readLine();
            if(word.matches(regex)) {
                System.out.println("Infected!");
            }else {
                System.out.println("Good");
            }
        }
        System.out.println(output);
    }
}
