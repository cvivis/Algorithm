

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static char K;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = (tokens.nextToken().charAt(0));
        int time = 0;
        int end = 3600 * (N+1);
        int result = 0;
        while(time < end){
            int s = time % 60;
            int m = (time / 60) % 60;
            int h = (time / 60) / 60;
            String ns = s<10? "0"+s:s+"";
            String nm = m<10? "0"+m:m+"";
            String nh = h<10? "0"+h:h+"";
//            System.out.println(nh + " "+ nm + " "+ ns);
            if((ns+nm+nh).indexOf(K)>-1){
                result++;
            }
            time++;
        }
        System.out.println(result);
    }
}
