import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        arr = new int[45];
        for(int i = 1; i < 45;i++){
            arr[i] = i * (i+1) / 2;
        }
//        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < N;i++){
            System.out.println(find(Integer.parseInt(br.readLine())));
        }

    }
    //3개를 고르는것이 확정이니 재귀 말고 그냥 반복문 3개로 하자
    private static int find(int input){
        for(int i = 1 ; i < arr.length;i++){
            for(int j = 1; j < arr.length;j++){
                for(int k = 1; k < arr.length;k++){
                    if(arr[i] + arr[j] + arr[k] == input){
//                        System.out.println(arr[i] + " "+ arr[j] + " "+arr[k]);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
