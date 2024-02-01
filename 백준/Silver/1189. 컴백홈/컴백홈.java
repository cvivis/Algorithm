

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소거리가 아닌 모든 가지수를 찾아야하기에 dfs로 풀어보자
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int R,C,K;
    static char[][] arr;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R;i++){
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }
        visited[R-1][0] = true;
        find(R-1,0,1);
        System.out.println(answer);
    }

    private static boolean isIn(int x , int y){
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    private static void find(int x ,int y,int dis){
        if(x == 0 && y == C-1 && dis == K ){
            answer++;
            return;
        }

        for(int i = 0; i < deltas.length;i++){
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];
            if(isIn(nx,ny) && !visited[nx][ny] &&arr[nx][ny] == '.'){
                visited[nx][ny] = true;
                find(nx,ny,dis+1);
                visited[nx][ny] = false;
            }
        }
    }
}
