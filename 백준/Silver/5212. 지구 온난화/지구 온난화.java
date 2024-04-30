import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


// R+2 , C+2로 후 외곽을 만들어주고 계산하니 4% 반례 -> 바다로 BFS 할려고 했더니 섬으로 바다가 끊어져 있을 수 있었음.
// 1. R,C로 수정후 풀기 , 2. 모든 바다를 다 하도록 하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int R,C;
    static char[][] input;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visit;
    static int[][] countSee;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        input = new char[R+2][C+2];
        visit = new boolean[R+2][C+2];
        countSee = new int[R+2][C+2];
        for(int i = 0 ; i < input.length;i++){
            Arrays.fill(input[i],'.');
        }
        for(int i = 1; i <= R;i++){
            String str = br.readLine();
            for(int j = 1; j <= C;j++){
                input[i][j] = str.charAt(j-1);
            }
        }
        for(int i = 0; i < R+2;i++){
            for(int j = 0; j < C+2;j++){
                if(input[i][j] == '.' && !visit[i][j]){
                    bfs(i , j);
                }
            }
        }
        after50(countSee);
        printMap();
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean isIn(int x , int y){
        return x >= 0 && y >= 0 && x < R+2 && y < C+2;
    }
    static void bfs(int x , int y){
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(new Node(x,y));
        visit[x][y] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny] == '.'){
                    visit[nx][ny] = true;
                    queue.offer(new Node(nx,ny));
                }
                else if(isIn(nx,ny) && input[nx][ny] == 'X'){
                    countSee[nx][ny]++;
                }
            }
        }
    }
    private static void after50(int[][] countSee){
        for(int i = 1 ; i <= R;i++){
            for(int j = 1; j <= C;j++){
                if(countSee[i][j] >= 3 ){
                    input[i][j] = '.';
                }
            }
        }
    }
    private static void printMap(){
        int minX = R, maxX = 0, minY = C,maxY = 0;
        for(int i = 1 ; i <= R;i++){
            for(int j = 1; j <= C;j++){
                if(input[i][j] == 'X' ){
                    minX = Math.min(minX,i);
                    maxX = Math.max(maxX,i);
                    minY = Math.min(minY,j);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        for(int i = minX; i <= maxX;i++){
            for(int j = minY; j <= maxY;j++){
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
  //      if(minX > maxX || minY > maxY){
   //         System.out.println('X');
     //   }
    }
}
