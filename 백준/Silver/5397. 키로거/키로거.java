
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            findPassword(input);
        }
        System.out.println(output);
    }
    private static void findPassword(String input) {
        String password = "";
        int cursor = 0;

        List<String> list = new LinkedList<>();
        ListIterator<String> iter = list.listIterator();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (input.charAt(i) == '>') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (input.charAt(i) == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
            } else {
                iter.add(input.charAt(i) + "");
            }
//            System.out.println(list + " cursor "+ cursor);
        }
        for(String s :list){
            output.append(s);
        }
       output.append("\n");

    }
}
