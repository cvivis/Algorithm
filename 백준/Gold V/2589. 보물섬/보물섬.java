

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, M;
    static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] input;
    static int count = 0;
    static boolean[][][][] disVisit;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new char[N][M];
        disVisit = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (input[i][j] == 'L') {
                    int cnt = Bfs(i, j);
                    if (count < cnt) {
                        count = cnt;
                    }
                }
            }
        }
        System.out.println(count);

//        for(char[] arr : input){
//            System.out.println(Arrays.toString(arr));
//        }
}

private static class Node {
    int x;
    int y;
    int dis;

    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

}

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static int Bfs(int startX, int startY) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        visit[startX][startY] = true;

        queue.offer(new Node(startX, startY, 0));
        int distance = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.dis > distance) {
                distance = now.dis;
            }
            for (int i = 0; i < deltas.length; i++) {
                int nx = now.x + deltas[i][0];
                int ny = now.y + deltas[i][1];
                if (isIn(nx, ny) && !visit[nx][ny] && input[nx][ny] == 'L') {
                    queue.offer(new Node(nx, ny, now.dis + 1));
                    visit[nx][ny] = true;

//                    System.out.println(startX + " " + startY + " " + nx + " " + ny + " visit");
                }
            }
        }
        return distance;
    }
}
