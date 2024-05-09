

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M,K;
    static int[][] input;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static List<Node> list = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        input = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        for(int i = 0;i < K;i++){
            tokens = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokens.nextToken());
            int y = Integer.parseInt(tokens.nextToken());
            input[x][y] = 1;
            list.add(new Node(x,y));
        }
        for(Node node : list){
            int count = bfs(node);
            result = Math.max(count,result);
        }
        System.out.println(result);
    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static boolean isIn(int x , int y){
        return x > 0 && y > 0 && x <= N && y <= M;
    }
    private static int bfs(Node node){
        int size = 1;
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        visit[node.x][node.y] = true;
        while(!q.isEmpty()){
            Node now = q.poll() ;
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny] == 1){
                    size++;
                    q.add(new Node(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
        return size;
    }
}
