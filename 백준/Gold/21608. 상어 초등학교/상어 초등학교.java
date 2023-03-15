import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] input;
    static int[][] result;
    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static ArrayList<ArrayList> likeList = new ArrayList<>();

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static void findMaxLike(int studentNum) {// input의 인덱스가 입력값
        int maxIdxX = 0;
        int maxIdxY = 0;
        int max = Integer.MIN_VALUE; // 좋아하는 사람 MAX인 수 비교
        int maxBlank = Integer.MIN_VALUE;
        for (int i = N - 1; i > -1; i--) { // 3번 조건
            for (int j = N - 1; j > -1; j--) {
                int count = 0;
                int blankCount = 0;
                for (int k = 0; k < deltas.length; k++) {
                    int nx = i + deltas[k][0];
                    int ny = j + deltas[k][1];
                    if (isIn(nx, ny) && likeList.get(studentNum).contains(result[nx][ny])) { // 아래와 갯수가 다르다
                        count++;
                    }
//                    if (isIn(nx, ny)){
//                        if(likeList.get(studentNum).contains(result[nx][ny])){
//                            count++;
//                        }
//                    }
                    else if (isIn(nx, ny) && result[nx][ny] == 0) {
                        blankCount++;
                    }
                }
                if (result[i][j] == 0) {
                    if (max < count) { // 1번조건
                        maxBlank = blankCount;
                        max = count;
                        maxIdxX = i;
                        maxIdxY = j;

                    } else if (max == count) { // 2번조건
                        if (blankCount >= maxBlank) {
                            max = count;
                            maxBlank = blankCount;
                            maxIdxX = i;
                            maxIdxY = j;

                        }
                    }
                }
            }
        }
        result[maxIdxX][maxIdxY] = studentNum; // 결과 값 세팅
    }

    private static void findSactisfaction() {
        int saticefaction = 0;
        for (int i = N - 1; i > -1; i--) {
            for (int j = N - 1; j > -1; j--) {
                int num = result[i][j];
                int likeNum = 0;
                for (int k = 0; k < deltas.length; k++) {
                    int nx = i + deltas[k][0];
                    int ny = j + deltas[k][1];
                    if (isIn(nx, ny) && likeList.get(num).contains(result[nx][ny])) {
                        likeNum++;
                    }
                }
                if (likeNum == 1) {
                    saticefaction++;
                } else if (likeNum == 2) {
                    saticefaction += 10;
                } else if (likeNum == 3) {
                    saticefaction += 100;
                } else if (likeNum == 4) {
                    saticefaction += 1000;
                }
            }
        }
        System.out.println(saticefaction);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N * N][5];
        for (int i = 0; i < N * N + 1; i++) {
            likeList.add(new ArrayList());
        }
        for (int i = 0; i < N * N; i++) {
            tokens = new StringTokenizer(br.readLine());
            int num = 0;
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(tokens.nextToken());
                num = input[i][0];
                if (j > 0) {
//                    str += input[i][j] + " "; // 1234로 하면 12, 포함됨.
                    likeList.get(num).add(input[i][j]);
                }
            }
        }

        result = new int[N][N];

        for (int i = 0; i < input.length; i++) {
            int studentNum = input[i][0];
            findMaxLike(studentNum);
        }

        findSactisfaction();
    }
}

