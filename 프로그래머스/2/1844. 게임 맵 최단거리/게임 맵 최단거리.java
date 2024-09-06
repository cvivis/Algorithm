import java.util.*;

class Solution {
static boolean[][] visit;
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M;
    static class Node{
        int x ;
        int y ;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        int answer = bfs(maps);
        return answer;
    }
    public boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    public int bfs(int[][] maps){
        Queue<Node> q = new ArrayDeque<>();
        visit = new boolean[N][M];
        q.offer(new Node(0,0,1));
        visit[0][0] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == N-1 && now.y == M-1){
                return now.dis;
            }
            for(int i = 0; i < delta.length;i++){
                int nx = now.x + delta[i][0];
                int ny = now.y + delta[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && maps[nx][ny] == 1){
                    visit[nx][ny] = true;
                    q.offer(new Node(nx,ny,now.dis+1));
                }
            }
        }
        return -1;
    }
}