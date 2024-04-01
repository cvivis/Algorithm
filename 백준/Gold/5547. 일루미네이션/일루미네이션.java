

import org.w3c.dom.Node;

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
    static int W,H;
    static int[][] input;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{1,0},{0,1},{1,1},{-1,1},{0,-1},{-1,-1},{-1,0},{0,1},{1,0},{1,-1},{0,-1}};
//    static int[][] deltas2 = {};
    static int[][] counts;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        W = Integer.parseInt(tokens.nextToken());
        H = Integer.parseInt(tokens.nextToken());
        input = new int[H+2][W+2];
        counts = new int[H+2][W+2];
        visit = new boolean[H+2][W+2];
        for(int i = 1 ; i <= H;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= W;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        System.out.println(bfs());

    }
    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    private static boolean isIn(int x , int y){
        return x >= 0 && y >= 0 && x <= H + 1 && y <= W + 1;
    }
    private static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0));
        visit[0][0] = true;
        int count = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            int start;
            int end;
            if(now.x % 2 == 1){
                start = 0;
                end = 5;
            }else{
                start = 6;
                end = 11;
            }
            for(int i = start; i <= end;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx, ny)){
                    if(!visit[nx][ny] && input[nx][ny] == 0){
                        q.offer(new Node(nx,ny));
                        visit[nx][ny] = true;
                    }
                    else if(input[nx][ny] == 1){
                        count++;
//                        counts[nx][ny]++;
                    }

                }
            }
        }
        return count;
    }
}
