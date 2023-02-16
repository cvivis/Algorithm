import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int[][] arr;
    static int N;
    static int M;
    static int K; // 연산횟수
    static int[][] doK;
    static int[][] loc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] com;
    static boolean[] isSelected;
    static int[][] comResult;
    static int index = 0;
    static int min = Integer.MAX_VALUE;
    static int[][] tempArr;


    public static void find(int cnt) {
        if (cnt == K) {
            //            System.out.println(Arrays.toString(com));
            comResult[index] = Arrays.copyOfRange(com, 0, com.length);
            index++;
            return;
        }
        for (int i = 0; i < K; i++) {
            if (isSelected[i]) continue;
            com[cnt] = i;
            isSelected[i] = true;
            find(cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void rotate(int numX, int numY, int s) throws IOException {

        boolean[][] visited = new boolean[N + 1][M + 1];
        int x = numX;
        int y = numY;
        int idx = 0;
        int pre = tempArr[x][y];
        int tmp = 0;
/*
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
* */
        while (idx < 4) {
            int xx = x + loc[idx][0];
            int yy = y + loc[idx][1];
            //			for (int[] nums : arr) {
            //				System.out.println(Arrays.toString(nums));
            //			}
            //			System.out.println(xx + " "+yy);
            if (yy >= numY && xx <= numX + s * 2 && xx >= numX && yy <= numY + s * 2) {
                //                System.out.print(arr[xx][yy] + " ");
                if (!visited[xx][yy]) {
                    tmp = tempArr[xx][yy];
                    tempArr[xx][yy] = pre;
                    pre = tmp;
                    visited[xx][yy] = true;
                    y = yy;
                    x = xx;
                } else {
                    idx++;
                }
            } else {
                //                System.out.println("asdf");
                idx++;
            }

            //		}
            //		for (int[] nums : arr) {
            //			System.out.println(Arrays.toString(nums));
            //		}

        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        arr = new int[N + 1][M + 1];
        doK = new int[K][3];
        com = new int[K]; // 조합1개 담기
        isSelected = new boolean[K];
        comResult = new int[721][3]; // 조합의 배열

        for (int i = 1; i <= N; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        //		for(int[] nums:arr) {
        //			System.out.println(Arrays.toString(nums));
        //		}
        for (int i = 0; i < K; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                doK[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        find(0);
//        for (int[] nums : comResult) {
//            System.out.println(Arrays.toString(nums));
//        }
        //시작 좌표는 (3,4,2)에서 -2한 1,2
        for (int i = 0; i < index; i++) {
            tempArr = new int[N + 1][M + 1];
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k < M + 1; k++) {
                    tempArr[j][k] = arr[j][k];
                }
            }
            for (int j = 0; j < K; j++) {
                int s = doK[comResult[i][j]][2];
                int x = doK[comResult[i][j]][0] - s;
                int y = doK[comResult[i][j]][1] - s;
//                System.out.printf("%d %d %d", x, y, s);

                while (s >= 1) {
//                    System.out.printf("%d %d %d\n", x, y, s);
//                    System.out.println("______________________");
//                    for (int[] nums : tempArr) {
//                        System.out.println(Arrays.toString(nums));
//                    }
                    rotate(x, y, s);
                    s -= 1;
                    x = x + 1;
                    y = y + 1;
                }


            }
            for (int j = 1; j < N + 1; j++) {
                int sum = 0;
                for (int k = 0; k < M + 1; k++) {
                    sum += tempArr[j][k];
                }
//                System.out.println(sum);
                if (min > sum) min = sum;
            }

        }
        System.out.println(min);
    }
}