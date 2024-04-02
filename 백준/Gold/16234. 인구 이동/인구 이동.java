

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 각 칸 간의 인구이동 여부 체크 N^2
// 2. 그룹핑 N^2
// 3. 연합 별 인구 조정
// 4. 반복하기

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,L,R;
    static int[][] board;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        L = Integer.parseInt(tokens.nextToken());
        R = Integer.parseInt(tokens.nextToken());
        board = new int[N][N];

        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++){
                board[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int closeCnt = 0;
        int day = 0;
        while(true){
            closeCnt = 0;
            visit = new boolean[N][N];
            for(int i = 0; i < N;i++){
                for(int j = 0; j < N; j++){
                    if(!visit[i][j]){
                        int group = findMove(i,j);
//                        System.out.println("asdfadf");
//                        if(group == 1){
                            closeCnt++;
//                        }
                    }
                }
            }
            if(closeCnt == N * N)break;
            day++;
        }
        System.out.println(day);


    }

    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
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
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    private static int findMove(int x, int y){
        List<Node> list = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        Node start = new Node(x,y);
        q.offer(start);
        list.add(start);
        visit[x][y] = true;
        int populationSum = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
//            System.out.println(q);
            populationSum += board[now.x][now.y];
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny]){
                    int gap = Math.abs(board[now.x][now.y] - board[nx][ny]);
                    if(gap >= L && gap <= R){
                        visit[nx][ny] = true;
                        Node next = new Node(nx,ny);
                        q.offer(next);
                        list.add(next);
                    }
                }



            }
        }
        int population = populationSum / list.size();
        for(Node node : list){
            board[node.x][node.y] = population;
        }
//        System.out.println(list);
        return list.size();
    }
}
