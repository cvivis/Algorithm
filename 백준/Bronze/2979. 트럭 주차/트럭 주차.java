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
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        arr = new int[101];
        a = Integer.parseInt(tokens.nextToken());
        b = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < 3;i++){
            tokens = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());
            parking(start,end);
        }
        System.out.println(check());
    }
    private static void parking(int start, int end){
        for(int i = start;i<end;i++){
            arr[i] = arr[i]+1;
        }
    }
    private static int check(){
        int total = 0;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == 1){
                total += a;
            }
            else if(arr[i] == 2){
                total += b * 2;
            }
            else if(arr[i] == 3){
                total +=    c * 3;
            }
        }
        return total;
    }
}
