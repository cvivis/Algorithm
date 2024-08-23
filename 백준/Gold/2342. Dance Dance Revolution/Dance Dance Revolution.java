

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
힘) 중앙 - 2 , 인접 - 3, 반대 - 4, 같음 - 1
N = 100000이기에 O(N | NlogN)
d[i]..? 왼발, 오른발에 따라 최솟값이 달라질 수 있음
d[i][2] = i번째 수열에서 왼발 , 오른발을 옮겼을때의 최솟값
왼발 , 오른발 옮긴 경우의수 2가지에 대한 좌표를 둘다 관리해줘야할듯하다.
발을 갱신하지 말고 그냥 몇번째 때 왼발 오른발로 ... -> 3중 배열
-> 뭔가 잘 고민한거같은데 검증이나 이런게 명쾌하게 안됨.... 코드가 내손에서 도망가요~~~
-> 문제점 직전 발좌표를 계속 관리해야한다는 문제 -> 검증도 힘듬
찾아보니 l,r좌표 모두 배열의 인덱스로 사용해 3중배열로 접근
- 바로 직전 i-1의 좌표에 최솟값과 비교해 하는 방식은 그리디적으로 진행 -> 반례가 존재 -> 앞으로 진행하다 같은게 나오면 그게 더 이득
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static final int LEFT = 0, RIGHT = 1;
    static int N;
    static int[][][] dp;
    static int[] input;
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        String[] temp = br.readLine().split(" ");
        input = new int[temp.length];
        for (int i = 1; i <= temp.length - 1; i++) {
            input[i] = Integer.parseInt(temp[i - 1]);
        }
//        System.out.println(Arrays.toString(input));
        dp = new int[input.length][5][5]; // i번째 수열의 l,r좌표에서의 최솟값
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }
        dp[1][0][input[1]] = 2;
        dp[1][input[1]][0] = 2;
        for (int i = 2; i < dp.length; i++) {
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[i - 1][l][r] != MAX) {
                        int left = power(l, input[i]);
                        int right = power(r, input[i]);
//                        if (left > right) {
                            dp[i][l][input[i]] = Math.min(dp[i][l][input[i]],dp[i - 1][l][r] + right);
//                        } else {
                            dp[i][input[i]][r] = Math.min(dp[i][input[i]][r],dp[i - 1][l][r] + left);
//                        }
                    }
                }
            }
        }
//        for(int i = 1; i < dp.length;i++){
//            for(int j = 0; j < dp[i].length;j++){
//                System.out.println(Arrays.toString(dp[i][j]));
//            }
//            System.out.println("----------");
//        }
        int min = MAX;
            for (int j = 0; j < dp[input.length-1].length; j++) {
                for(int k = 0; k < dp[input.length-1][j].length;k++){
                    if(dp[input.length-1][j][k] != -1 && min > dp[input.length-1][j][k]){
                        min = dp[input.length-1][j][k];
                    }
                }
            }
        System.out.println(min);
    }

    private static int power(int before, int after) {
        if (before == 0) {
            return 2;
        } else if (Math.abs(before - after) == 2) {
            return 4;
        } else if (Math.abs(before - after) % 2 == 1) {
            return 3;
        } else if (before == after) {
            return 1;
        } else {
            return 1000000;
        }
    }

}
