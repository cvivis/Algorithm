

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int R,C,K;
    static char[][] input;
    static int count = 0;
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        input = new char[R][C];
        visit = new boolean[R][C];
        for(int i = 0; i < R;i++){
            String str = br.readLine();
            for(int j = 0; j < C;j++){
                input[i][j] = str.charAt(j);
            }
        }
        visit[R-1][0] = true;
        find(R-1,0,1);
        System.out.println(count);
    }

    private static boolean isIn(int x , int y){
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    private static void find(int x, int y , int dis){
        if(x == 0 && y == C-1){
            if(dis == K){
                count++;
            }
            return;
        }
        for(int i = 0; i < delta.length;i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
//            System.out.println(nx + " "+ ny);
            if(isIn(nx,ny) && input[nx][ny] != 'T' && !visit[nx][ny]){
                visit[nx][ny] = true;
                find(nx,ny,dis+1);
                visit[nx][ny] = false;
            }
        }

    }
}
