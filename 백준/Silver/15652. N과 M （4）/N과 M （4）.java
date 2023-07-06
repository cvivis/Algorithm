import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] arr;
    private static void find(int n, int r ){
//        System.out.println(r + " "+ M);
        if(r == M){
           for(int i = 0 ; i < arr.length;i++){
               System.out.print(arr[i]+" ");
           }
            System.out.println();

        }else{
            for(int i = n; i <= N;i++){
                arr[r] = i;
                find(i, r+1);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        arr = new int[M];
        find(1,0);
        System.out.println(output + "\n");
    }


}
