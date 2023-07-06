import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int M, N, H;
    static int[][][] input;
    static int[][] delta = {{-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0,1}, {0, 0,-1}};

    static Queue<Node> q = new ArrayDeque<>();
    static int day = 0;
    static int result = 0;
    static boolean visit[][][];

    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;

        }
    }

    private static boolean isIn(int x, int y,int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < N && y < M && z < H;
    }

    private static void Bfs() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++){
                    if (input[i][j][k] == 1) {
                        visit[i][j][k] = true;
                        q.offer(new Node(j,k,i));
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            int len = q.size();
            day++;
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < N; j++) {
//                    for(int k = 0; k < M; k++) {
//                        System.out.print(input[i][j][k]+" ");
//                    }
//                    System.out.println("\n");
//                }
//
//            }
//            System.out.println("-------------------");
            for (int d = 0; d < len; d++) {
                Node now = q.poll();
                for (int i = 0; i < delta.length; i++) {
//                    System.out.println(now);
                    int nx = now.x + delta[i][0];
                    int ny = now.y + delta[i][1];
                    int nz = now.z + delta[i][2];
//;  System.out.println(nx+" "+ ny+ " "+ nz);
                    if (isIn(nx, ny, nz) && !visit[nz][nx][ny] && input[nz][nx][ny] == 0) {

                        input[nz][nx][ny] = 1;
                        visit[nz][nx][ny] = true;
                        q.offer(new Node(nx, ny,nz));
                    }
                }

            }



        }

    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        H = Integer.parseInt(tokens.nextToken());
        input = new int[H][N][M];
        visit = new boolean[H][N][M];
        boolean tomatoCheck = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                tokens = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < M;k++) {
                    input[i][j][k] = Integer.parseInt(tokens.nextToken());
                    if (input[i][j][k] == 0) {
                        tomatoCheck = true;
                    }
                }
            }
        }
        Bfs();
        result = day-1;
//        for (int arr[] : input) {
//            System.out.println(Arrays.toString(arr));
//        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for(int k = 0; k < M;k++){
                    if (input[i][j][k] == 0) {
                        result = -1;
                        break;
                    }
                }

            }
        }
        if (!tomatoCheck) {
            result = 0;
        }
        System.out.println(result + "\n");

    }
}
