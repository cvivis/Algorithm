

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

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = new int[N][N];
        visit = new boolean[N][N];
        List<Integer> groupSize = new ArrayList<>();
        for(int i = 0; i < N;i++){
            String str = br.readLine();
            for(int j = 0 ; j < N;j++) {
                input[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
//        for(int[] arr : input){
//            System.out.println(Arrays.toString(arr));
//        }
        for(int i = 0 ;i < N;i++){
            for(int j = 0; j < N;j++){
                if(input[i][j] == 1 && !visit[i][j]){
                    groupSize.add(find(i,j));
                }
            }
        }
        Collections.sort(groupSize);
        System.out.println(groupSize.size());
        groupSize.forEach(System.out::println);

    }
    private static class Node{
        int x;
        int y;
        public Node(int x , int y){
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
    private static boolean isIn(int x, int y){
        return x >=0 && y >= 0 && x < N && y < N;
    }
    private static int find(int x , int y){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y));
        visit[x][y] = true;
        int size = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0; i < deltas.length;i++){
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if(isIn(nx,ny) && !visit[nx][ny] && input[nx][ny] == 1){
                    q.offer(new Node(nx,ny));
                    size++;
                    visit[nx][ny] = true;
                }
            }
        }
        return size;
    }
}
