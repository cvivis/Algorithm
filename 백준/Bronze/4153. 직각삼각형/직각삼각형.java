import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        String str = "";
        while(true){
            str = input.readLine();
            if(str.equals("0 0 0"))break;
            tokens = new StringTokenizer(str);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(tokens.nextToken());
            }
            Arrays.sort(arr);
            if(Math.pow(arr[0],2)+Math.pow(arr[1],2) == Math.pow(arr[2],2)){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
        }
    }
}
