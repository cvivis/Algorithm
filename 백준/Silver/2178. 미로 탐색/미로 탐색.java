

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
    static int N,M;
    static int[][] input;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        for(int i = 1; i <= N;i++){
            String str = br.readLine();
            for(int j = 1 ; j <= M;j++) {
                input[i][j] = Integer.parseInt(str.charAt(j-1)+"");
            }
        }
        System.out.println(find());

    }
    private static class Node{
        int x;
        int y;
        int dis;
        public Node(int x , int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dis=" + dis +
                    '}';
        }
    }
    private static boolean isIn(int x, int y){
        return x > 0 && y > 0 && x <= N && y <= M;
    }
    private static int find(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(1,1,1));
        visit[1][1] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny] == 1){
                    q.offer(new Node(nx,ny,now.dis+1));
                    visit[nx][ny] = true;
                    if(nx == N && ny == M)return now.dis + 1;
                }

            }
        }
        return -1;
    }
}
