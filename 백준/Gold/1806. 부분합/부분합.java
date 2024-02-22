import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,S;
    static int[] len;
    static int[] sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());
        arr = new int[N];
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = arr[right];
        int len = Integer.MAX_VALUE;
//        if(arr[0] >= S){
//            len = 1;
//        }
        while(left<=right){
            if(sum<S){
                right++;
                if(right>=arr.length )break;
                sum += arr[right];
            }
            else if(sum>=S){
                if(len> (right - left + 1)){
                    len = (right - left + 1);
                }
                sum -= arr[left++];
            }

        }
        if(len == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(len);
        }

    }
}
