import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int a,b,c;
    static int[] time;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        a = Integer.parseInt(tokens.nextToken());
        b = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        time = new int[101];
        for(int i = 0; i < 3;i++){
            tokens = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());
            parking(start, end);
        }
//        System.out.println(Arrays.toString(time));
        System.out.println(checkMoney());
    }

    private static void parking(int start , int end){
        for(int i = start; i < end;i++){
            time[i]++;
        }
    }

    private static int checkMoney(){
        int cost = 0;
        for(int i = 1; i < time.length;i++){
            if(time[i] == 1){
                cost += a;
            }
            else if(time[i] == 2){
                cost += (b * 2);
            }
            else if(time[i] == 3){
                cost += (c * 3);
            }
        }
        return cost;
    }
}
