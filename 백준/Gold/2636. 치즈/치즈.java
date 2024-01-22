import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



//

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] input;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visit;

    private static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static int bfs() {
        visit = new boolean[N][M];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        visit[0][0] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i = 0; i < deltas.length; i++) {
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if (isIn(nx, ny) && !visit[nx][ny]) {
                    if (input[nx][ny] == 0) {
                        q.offer(new Pair(nx, ny));
                    } else {
                        input[nx][ny] = 0;
                        cnt++;
                    }
                    visit[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < M;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int beforeMelted = 0;
        int time = 0;
        int lastCnt = 0;
        while(true){
            int cnt = bfs();
            if(cnt != 0 ){
                time++;
                lastCnt = cnt;
            }
            else{
                break;
            }
        }


        System.out.println(time);
        System.out.println(lastCnt);
    }
}
