



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int M,N;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visit;
    static int[][] input;
    static int allCnt = 0;
    static Queue<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        input = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < M;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int i = 0; i < N;i++){
            for(int j = 0; j < M;j++){
                if(input[i][j] == 1){
                    queue.offer(new Node(i,j,0));
                    visit[i][j] = true;
                }
                else if(input[i][j] == 0){
                    allCnt++;
                }
            }
        }
        System.out.println(Bfs());

    }
    private static class Node{
        int x;
        int y;
        int day;
        public Node(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    private static boolean isIn(int x, int y ){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    private static int Bfs(){
        int count = -1;
        while(!queue.isEmpty()){
           Node now = queue.poll();
           count= now.day;
            for(int i = 0;i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny]==0){
                    queue.offer(new Node(nx,ny,now.day+1));
                    visit[nx][ny] = true;
                    allCnt--;
                }
            }
        }
        if(allCnt != 0)return -1;
        return count;
    }
}
