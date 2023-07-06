import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] input;
    final static int INF = 10000001; // 100000 * 100 경로
    private static void floyd(){
        for(int k = 1; k <= N;k++){
            for(int i = 1;i<=N;i++){
                for(int j = 1;j <=N;j++){
                    if(input[i][k] != INF && input[k][j] != INF){
                        input[i][j] = Math.min(input[i][j], input[i][k] + input[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        input = new int[N+1][N+1];
        for(int i = 0 ; i <= N;i++){
            for(int j = 0; j <= N;j++){
                input[i][j] = INF;
            }
        }
        for(int i = 0; i < M;i++){
            tokens = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int cost = Integer.parseInt(tokens.nextToken());
            if(input[from][to] != INF){
                input[from][to] = Math.min(input[from][to] , cost);
            }
            else {
                input[from][to] = cost;
            }
        }
//        for(int arr[] : input){
//            System.out.println(Arrays.toString(arr));
//        }
//
//        System.out.println("-----------------------------");

        floyd();

            for(int i =1; i <=N;i++){
                for(int j = 1; j <= N;j++){
                    if(i == j || input[i][j] == INF)input[i][j] = 0;
                    output.append(input[i][j] + " ");
                }
                output.append("\n");
            }
//        for(int arr[] : input){
//            System.out.println(Arrays.toString(arr));
//        }
        System.out.println(output);
    }


}
