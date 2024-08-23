import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
25114 - B,Y,A,K,A,D,N
2/5/1/1/4 , 25/1/1/4, 25/11/4, 25/1/14, 2/5/11/4, 2/5/1/14
5000자리 - 완전탐색 불가능
dp - 앞에서 부터 끊어서 보기
dp[i] = i 자리 영어의 암호화 가짓수
dp[i] = 1. 새로 붙인 숫자가 1~9를 앞에 수와 별도로 칠때 d[i-1]의 가짓수를 가진다., 2. 앞에 숫자와 포함해 10 ~ 26 -> 이 경우 앞에 숫자와 포함하기 때문에 가짓수는 d[i-2]

14% 반례 - % 1000000 , 0처리
26% 반례 - 0처리
01이라는 알파뱃은 없기때문에 안되는것으로 판정해야함

* */


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int[] dp;
    static char[] input;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        input = new char[str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            input[i] = str.charAt(i - 1);
        }
        dp = new int[input.length];
        dp[0] = 1;
        if (Integer.parseInt(input[1] + "") != 0) {
            dp[1] = 1;
        }
        for (int i = 2; i < input.length; i++) {
            int digit = Integer.parseInt(input[i] + "");
            int digit2 = Integer.parseInt(input[i - 1] + "" + input[i] + "");
//            System.out.println(digit + " "+ digit2);
            if (digit >= 1 && digit <= 9) {
                dp[i] += dp[i - 1] % 1000000;
            }
            if (digit2 >= 10 && digit2 <= 26) {
                dp[i] += dp[i - 2] % 1000000;
            }
            dp[i] %= 1000000;
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[str.length()]);
    }
}
