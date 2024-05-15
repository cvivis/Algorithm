
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] input;
    static boolean[][] visit;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static List<Node> list = new ArrayList<>();
    static  int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int id = 2;
        for(int i = 0; i < N;i++){
            for(int j = 0; j < N;j++){
                if(input[i][j] == 1 && !visit[i][j]){
//                    list.add(new ArrayList<>());
                    findIsland(i,j,id);
                    id++;
                }
            }
        }
//        for(int[] arr : input){
//            System.out.println(Arrays.toString(arr));
//        }
        for(int i = 0; i < list.size();i++){
            int result = findShort(list.get(i).x , list.get(i).y,list.get(i).island);
//            System.out.println(result);
            min = Math.min(result,min);
        }
        System.out.println(min);
    }
    private static class Node{
        int x;
        int y;
        int island;

        public Node(int x, int y,int island) {
            this.x = x;
            this.y = y;
            this.island = island;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", island=" + island +
                    '}';
        }
    }
    private static boolean isIn(int x , int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    private static void findIsland(int x, int y,int id){
        Queue<Node> q = new ArrayDeque<>();
        Node node = new Node(x,y,id);
        q.offer(node);
        visit[x][y] = true;
        input[x][y] = id;
        while(!q.isEmpty()){
            Node now = q.poll();
            boolean check = false;
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];

                if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny] == 1){
                    Node next = new Node(nx,ny,id);
                    q.offer(next);
                    visit[nx][ny] = true;
                    input[nx][ny] = id;
                }
                if(isIn(nx,ny) && input[nx][ny] == 0){
                    check = true;
                    input[now.x][now.y] = id * -1;
                }
            }
            if(check)list.add(now);
        }
    }

    private static int findShort(int x,int y,int id){
//        System.out.println(x + " "+y );
        visit = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y,0)); // island 여기서는 거리로 쓰기
        visit[x][y] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(min < now.island)break;
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny]){
                    if(input[nx][ny] != 0 && input[nx][ny] != id && input[nx][ny] != id * (-1)){
                        return now.island;
                    }
                        q.offer(new Node(nx,ny,now.island+1));
                        visit[nx][ny] = true;
                }
            }
        }
        return min;
    }

}
