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
    static int N,M;
    static int[][] input;
    static boolean[][][] visited;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    static class Node{
        int x;
        int y;
        int sum;
        int count;

        public Node(int x, int y, int sum, int count) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", sum=" + sum +
                    ", count=" + count +
                    '}';
        }
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static int bfs(){
        Queue<Node> q = new ArrayDeque(){};
        q.offer(new Node(0,0,1,0));
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == N-1 && now.y == M-1){
                return now.sum;
            }
            for(int i =0 ; i<deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) &&  now.count<2 && !visited[nx][ny][1<<now.count]){
                    int count = now.count;
                    if(now.count == 1 && input[nx][ny] == 1){
                        continue;
                    }
                    if(now.count == 0 && input[nx][ny] == 1){
                        count++;
                    }
                        q.offer(new Node(nx,ny,now.sum+1,count));
                        visited[nx][ny][1<<count] = true;


                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N][M];
        visited = new boolean[N][M][1<<2];

        for(int i = 0 ; i < N;i++){
           String str = br.readLine();
            for(int j = 0; j < M;j++){
                input[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        System.out.println(bfs());
    }
}
