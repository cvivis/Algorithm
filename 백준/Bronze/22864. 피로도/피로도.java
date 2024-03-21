import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int A,B,C,M;
    static int sumTire = 0;
    static int work = 0;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        A = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        int time = 0;
        while(time < 24){
//            System.out.println(time + " "+work);
            if(sumTire+A <= M){
                sumTire+=A;
                work+=B;
            }else{
                sumTire-=C;
                if(sumTire<0){
                    sumTire = 0;
                }
            }
            time++;
        }
        System.out.println(work);
    }
}
