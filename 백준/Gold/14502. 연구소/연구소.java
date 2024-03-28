

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] input;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static List<int[]> walls = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();
    static int[] select = new int[3];
    static int result = Integer.MIN_VALUE;
    static int initWall;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input= new int[N][M];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < M;j++) {
                input[i][j] = Integer.parseInt(tokens.nextToken());
                if(input[i][j] == 0){
                    int[] temp = {i,j};
                    walls.add(temp);
                }
                else if(input[i][j] == 2){
                    int[] temp = {i,j};
                    virus.add(temp);
                }
            }
        }
        initWall = N * M - walls.size() - virus.size();
//        for (int[] temp : virus){
//            System.out.println(Arrays.toString(temp));
//        };
//        System.out.println(initWall);
        combi(0,0);
        System.out.println(result);
    }
    private static void change(){
        for(int i = 0; i < select.length;i++){
            int x = walls.get(select[i])[0];
            int y = walls.get(select[i])[1];
            input[x][y] = input[x][y] == 1? 0:1;
        }
    }
    private static void combi(int cnt,int start){
        if(cnt == 3){
//            System.out.println(Arrays.toString(select));
            change();
            int temp = Bfs();
//            System.out.println(temp);
//            if(temp != N * M - initWall - temp){
                result = Math.max(N * M - initWall - temp - 3,result);
//            }
            change();
            return;
        }
        for(int i = start; i < walls.size();i++){
            select[cnt] = i;
            combi(cnt+1,i+1);
        }
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
        return x >=0 && y >= 0 && x < N && y < M;
    }
    private static  int Bfs(){
        Queue<Node> q = new ArrayDeque<>();
        visit = new boolean[N][M];
        for(int[] temp : virus){
            q.offer(new Node(temp[0],temp[1]));
        }
        int count = virus.size();
        while(!q.isEmpty()){
            Node now = q.poll();
//            System.out.println(q);
            for(int i = 0;i<deltas.length;i++) {
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && (input[nx][ny] == 0)){
                    q.offer(new Node(nx,ny));
                    count++;
                    visit[nx][ny] = true;
                }
            }
        }
        return count;
    }
}
