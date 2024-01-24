import java.io.*;
import java.util.StringTokenizer;
public class Main {
    private static StringTokenizer tokens;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(br.readLine());
        long a = Long.parseLong(tokens.nextToken());
        long b = Long.parseLong(tokens.nextToken());
        long c = Long.parseLong(tokens.nextToken());
        System.out.println(a + b + c);

    }
}