import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

// MCN 세기
// M! / M-N! * N!
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int T;
   static long [][] arr = new long[31][31];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        T = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < T;i++){
            tokens = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tokens.nextToken());
            int M = Integer.parseInt(tokens.nextToken());
            System.out.println(find(M,N));
        }
    }
    private static long find(int m , int n){
      if(arr[m][n] != 0)return arr[m][n];
        if(m == n || n == 0 ){
            arr[m][n] = 1;
            return arr[m][n];
        }
        return arr[m][n] = find(m-1 , n-1) + find(m-1,n);
    }
}
