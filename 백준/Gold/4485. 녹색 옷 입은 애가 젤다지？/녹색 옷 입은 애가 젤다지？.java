

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최단거리 알고리즘
// BFS 접근 -> visit체크를 하면 다른 길로 돌아갔을때 최소가 나올 가능성이 배제됨
// visit 체크 없이 크기 비교로 큐에 계속 값을 넣음 -> 브루트 포스로 모든 가능성 다 확인 -> 셀에 올 수 있는 값이 9이기 때문에 그 가지수가 적어서 가능은 하다.
// 다익스트라 -> 모든 지점에서의 루피가 최소가 되는 값을 그리디로 알 수 있음
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] dist;
    static int[][] input;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        int count = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            input = new int[N][N];
            if(N == 0)break;
            dist = new int[N][N];
            visit = new boolean[N][N];
            for(int i = 0; i < N;i++){
                Arrays.fill(dist[i],(int)1e9);
            }
            for(int i = 0; i < N;i++){
                tokens = new StringTokenizer(br.readLine());
                for(int j = 0; j < N;j++){
                    input[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
            dist[0][0] = input[0][0];
            dijkstra();
            System.out.println("Problem "+count+ ": "+dist[N-1][N-1]);
            count++;
        }
    }
    private static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    private static void dijkstra(){
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(0,0,dist[0][0]));
        while(!pq.isEmpty()){
            Element now = pq.poll();
            visit[now.x][now.y] = true;
            if(now.sum != dist[now.x][now.y])continue;
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny]){
                    int nextSum = input[nx][ny];
                    if(now.sum + nextSum <= dist[nx][ny]){
                        dist[nx][ny] = now.sum + nextSum;
                        pq.add(new Element(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }
    }
    static class Element implements Comparable<Element>{
        int x;
        int y;

        int sum;

        public Element(int x,int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        @Override
        public int compareTo(Element o) {
            return this.sum - o.sum;
        }
    }
}
