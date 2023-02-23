import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [키워드] dfs
 * <p>
 * [풀이과정]
 * 1. 처음 시작부터 dfs로 각 문자가 든 배열안 탐색하기
 * 2. 탐색하면서 탐색한 문자열 저장
 * 3. 문자열과 탐색할려고 하는 문자 비교하여 새로운 문자열만 추가
 * 4. 길이 출력하기
 * [입력]
 * [출력]
 *
 * @author
 * @performance
 * @category
 * @see
 */
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, M;
    static int[][] input;
    static boolean isVisited[][];
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//우하좌상
    static boolean visit[];
    static int result = 0;


    public static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void dfs(int x, int y, int count) {
        if (visit[input[x][y]]) {
            result = Math.max(result, count);
            return;
        } else {
            visit[input[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + deltas[i][0];
                int ny = y + deltas[i][1];

                if (isIn(nx, ny)) {
                    dfs(nx, ny, count + 1);
                }

            }
            visit[input[x][y]] = false;

        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N][M];
        isVisited = new boolean[N][M];
        visit = new boolean[26];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = s.charAt(j)-'A';
            }
        }
        dfs(0, 0, 0);
        System.out.println(result);
    }
}
