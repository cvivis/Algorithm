import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M,K;
    static List<FireBall>[][] board;
    static int[][] deltas = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static Queue<FireBall> fireBalls = new ArrayDeque<>();
    static class FireBall{
        int x;
        int y;
        int m;
        int s;
        int d;
        boolean use;

        public FireBall(int x, int y, int m, int s, int d,boolean use) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
            this.use = use;
        }

        @Override
        public String toString() {
            return "FireBall{" +
                    "x=" + x +
                    ", y=" + y +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    ", use=" + use +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        board = new ArrayList[N][N];
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length;j++){
                board[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < M;i++){
            tokens = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokens.nextToken())-1;
            int y = Integer.parseInt(tokens.nextToken())-1;
            int m = Integer.parseInt(tokens.nextToken());
            int s = Integer.parseInt(tokens.nextToken());
            int d = Integer.parseInt(tokens.nextToken());
            FireBall fireBall = new FireBall(x,y,m,s,d,true);
            board[x][y].add(fireBall);
            fireBalls.add(fireBall);
        }
        for(int i = 0; i < K;i++){
            move();
        }
        int sumM = 0;
//        System.out.println(fireBalls + " :: 최종 :: ");
        for(int i = fireBalls.size()-1; i >= 0 ;i--){
            FireBall f = fireBalls.poll();
            if(f.use){
                sumM += f.m;
            }
        }
        System.out.println(sumM);
    }
    private static void move(){
//        System.out.println(fireBalls);
        int size = fireBalls.size();
        for(int i = size-1; i >= 0;i--){
            FireBall now = fireBalls.poll();
            if(now.use && now.m != 0){
                int nx = (now.x + (deltas[now.d][0] * now.s)) % N;
                nx = nx < 0 ? nx + N : nx;
                int ny = (now.y + (deltas[now.d][1] * now.s)) % N;
                ny = ny < 0 ? ny + N : ny;
                board[now.x][now.y].remove(now);
                FireBall nFire = new FireBall(nx,ny,now.m,now.s,now.d,true);
                board[nx][ny].add(nFire);
                fireBalls.add(nFire);
            }
        }
//        System.out.println(fireBalls+": after");
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length;j++){
                if(board[i][j].size()>=2){
//                    fireBalls.remove()
                    next(i,j);
                };
            }
        }

    }
    private static void next(int x , int y){
        List<FireBall> list = new ArrayList<>();
        int size = board[x][y].size();
        int sumM = 0;
        int sumS = 0;
        int countDE = 0;
        int countDO = 0;
        for(int i = 0; i < size;i++){
            FireBall f = board[x][y].get(i);
            sumM += f.m;
            sumS += f.s;
            if(f.d % 2 == 0)countDE++;
            else countDO++;
            f.use = false;
        }
        int start = countDE == 0 || countDO == 0 ? 0 : 1;
        for(int i = start; i < 8; i = i+2){
            FireBall next = new FireBall(x,y,sumM/5,sumS/size,i,true);
            if(next.m != 0){
                list.add(next);
                fireBalls.add(next);
            }
        }
        board[x][y] = list;
    }
}
