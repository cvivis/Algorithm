
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] T, P;
    static int max = Integer.MIN_VALUE;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        T = new int[N+1];
        P = new int[N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(tokens.nextToken());
            P[i] = Integer.parseInt(tokens.nextToken());
        }
        find(0,0);
        System.out.println(max);
    }
//    private static void find(int day,int sum){
////            System.out.println(day + " "+ sum);
//        if(day <= N+1){
//            max = Math.max(max,sum);
//        }
//        for(int i = day; i <= N;i++){
//            if(i + T[i] -1 <= N && !visit[i]){
////                visit[i] = true;
//                find(i+T[i],sum + P[i]);
////                visit[i] = false;
//            }
//        }
//    }

    private static void find(int day,int sum){
        if(day >= N ){
            max = Math.max(max,sum);
            return;
        }
        if(day + T[day] <= N){
            find(day + T[day],sum + P[day]);
        }
        find(day+1,sum);
    }
}
