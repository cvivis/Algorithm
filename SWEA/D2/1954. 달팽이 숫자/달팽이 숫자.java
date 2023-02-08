import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] loc = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // count%4
    static int[][] arr;
    static int x;
    static int y;

    public static void main(String args[]) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][N + 1];
            int num;
            for (num = 1; num <= N; num++) {
                arr[0][num] = num;
            }
            x = 0;
            y = N;
            int cnt = N - 1;
            int dirSign = 0;
            while (cnt > 0) {
                for (int i = 0; i < cnt; i++) {
                    x = x + loc[dirSign % 4][0];
                    y = y + loc[dirSign % 4][1];
                    arr[x][y] = num;
                    num++;
                }
                dirSign++;
                for (int i = 0; i < cnt; i++) {
                    x = x + loc[dirSign % 4][0];
                    y = y + loc[dirSign % 4][1];
                    arr[x][y] = num;
                    num++;
                }
                dirSign++;
                cnt--;
            }
            output.append("#"+test_case+"\n");
            for(int i = 0; i < N;i++){
                for(int j = 1;j<N+1;j++){
                    output.append(arr[i][j]+" ");
                }
                output.append("\n");
            }
        }
        System.out.println(output);
    }
}
