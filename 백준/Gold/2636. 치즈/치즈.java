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
    static int r,c;
    static int[][] input;
    static boolean[][] visited;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        r = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        input = new int[r][c];
        for(int i = 0; i < r;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < c;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int result = 0;
        int time = 0;
        while(true){
            int count = bfs();
            if(count == 0){
                break;
            }
            else{
                result = count;
            }
            time++;
        }
        output.append(time + "\n");
        output.append(result + "\n");
        System.out.println(output);

    }

    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    private static int bfs(){
        int count = 0;
        visited = new boolean[r][c];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0,0));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visited[nx][ny]){
                    if(input[nx][ny] == 0){
                        queue.offer(new Node(nx,ny));
                    }
                    else if(input[nx][ny] == 1){
                        input[nx][ny] = 0;
                        count++;
                    }
                    visited[nx][ny] = true;
                }
            }
        }
        return count;
    }
}
