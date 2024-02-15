

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int R,C;
    static char[][] input;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[] alphabet = new boolean[26];
    static boolean[][] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        input = new char[R+1][C+1];
        visit = new boolean[R+1][C+1];
        for(int i = 0; i < R;i++){
            String str = br.readLine();
            for(int j = 0; j < C;j++){
                input[i+1][j+1] = str.charAt(j);
            }
        }
//        for(char[] arr : input){
//            System.out.println(Arrays.toString(arr));
//        }
        visit[1][1] = true;
        alphabet[input[1][1] - 'A'] = true;
        Dfs(1,1,1);
//        System.out.println('A' - 'A');
        System.out.println(count);
    }

    private static boolean isIn(int x, int y){
        return x > 0 && y > 0 && x <= R && y <= C;
    }
    private static void Dfs(int cnt,int x, int y){
//        System.out.println(cnt + " "+ x + " "+ y);
        if(cnt > count){
            count = cnt;
        }
        for(int i = 0; i < deltas.length;i++){
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];
//            System.out.println(input[nx][ny]);
            if(isIn(nx,ny) && !visit[nx][ny] && !alphabet[input[nx][ny] - 'A']){
                visit[nx][ny] = true;
                alphabet[input[nx][ny] - 'A'] = true;
                Dfs(cnt+1,nx,ny);
                visit[nx][ny] = false;
                alphabet[input[nx][ny] - 'A'] = false;
            }
        }
    }
}
