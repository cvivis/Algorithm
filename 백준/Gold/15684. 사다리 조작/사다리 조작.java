
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M,H;
    static boolean[][] pair;
    static int answer = Integer.MAX_VALUE;
    static boolean trigger;
    static int limit = 3;
    //연속 체크
    // i to i 체크
    // 갯수 1, 2, 3개 확인
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        H = Integer.parseInt(tokens.nextToken());

        pair = new boolean[H+1][N+1];
        for(int i = 0; i < M;i++){
            tokens = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            pair[a][b] = true;
        }

        selectPair(1,1,0);
        if(H==0){
            answer = 0;
        }
        else if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        System.out.println(answer);
    }
    private static void selectPair(int a, int b, int cnt){
//        if(trigger){
//            return;
//        }
        if(cnt >= answer) return;
        if(answer == 0) return;
        if(cnt <= limit){
            // 검증
            boolean result = checkPair();
            if(result){
//                for(boolean[] arr : pair){
//                    System.out.println(Arrays.toString(arr));
//                }
//                trigger = true;
                answer = cnt;
//                System.exit(0);
                return;
            }
        }
        else if(cnt > limit){
                return;
        }
        for(int i = 1; i <= H;i++){ // x
            for(int j = 1;j<N;j++){
                if(pair[i][j]){
                    continue;
                }
                else if(pair[i][j-1]){
                    continue;
                }
                if(cnt==3)return;
                pair[i][j] = true;
                selectPair(i,j,cnt+1);
                pair[i][j] = false;
            }
        }
    }

    private static boolean checkPair(){
        for(int i = 1; i <= N;i++){
            int startH = i; // 사다리
            int startW = 1; // 높이
            while(startW <= H){
//                System.out.println(startH + " "+ startW);
                if(startH <= N && startW <= H && (pair[startW][startH])){
                    startH++;
                }
                else if(startH <= N && startW <= H && (pair[startW][startH-1])){
                    startH--;
                }
                startW++;
            }
            if(startH != i){
                return false;
            }

        }
        return true;
    }
}
