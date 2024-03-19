
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int generator = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        find(0);
        if(generator == Integer.MAX_VALUE){
            generator = 0;
        }
        System.out.println(generator);
    }
    private static void find(int num){
        if(num>=N){
            return;
        }
        String str = num + "";
        int sum = 0;
        for(int i = 0; i < str.length();i++){
            sum += Integer.parseInt(str.charAt(i)+"");
        }
        if(sum + num == N){
            if(generator > num){
                generator = num;
            }
            return;
        }
        find(num+1);
    }
}
