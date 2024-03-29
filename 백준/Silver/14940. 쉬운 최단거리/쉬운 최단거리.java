
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] input;
    static boolean[][] visit;
    static int[] start = new int[2];
    static int[][] dis;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N][M];
        dis = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0 ; i < N;i++){
            Arrays.fill(dis[i],-1);
        }
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < M;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
                if(input[i][j] == 2){
                    start[0] = i;
                    start[1] = j;
                }
                else if(input[i][j] == 0){
                    dis[i][j]= 0;
                }
            }
        }
        Bfs();
        for(int i = 0; i < N;i++){
            for(int j = 0; j < M;j++){
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static class Node{
        int x;
        int y;
        int dis;

        public Node(int x, int y,int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

    }
    private static boolean isIn(int x, int y){
        return x >=0 && y >= 0 && x < N && y < M;
    }
    private static void Bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start[0], start[1],0));
        dis[start[0]][start[1]] = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0;i<deltas.length;i++) {
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny]){
                    if(input[nx][ny] == 0){
                        dis[nx][ny] = 0;
                    }
                    else if(input[nx][ny] == 1){
                        q.offer(new Node(nx,ny, now.dis+1));
                        dis[nx][ny] = now.dis+1;
                    }
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
