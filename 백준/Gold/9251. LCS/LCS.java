import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String str = "ABCDCBA";
//        String str2 = "DCABDC";
        String str = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str, str2));
    }

    public static void printMatrix(int[][] arr, int num, int num2) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num2; j++) {
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println();
        }
    }
    public static int max(int[][] arr, int num, int num2) {
        int max = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num2; j++) {
                if(max<arr[i][j])max = arr[i][j];
            }
        }
        return max;
    }


    public static int solution(String str, String str2) {

        int[][] arr = new int[str2.length() + 1][str.length() + 1]; //배열의 사이즈 [행][열]

        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str.length() + 1; j++) {
                if (i == 0 || j == 0) arr[i][j] = 0; // 빈문자열 비교를 위해 행 열 0번째는 다 0으로 채우기
            }
        }

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str.length() + 1; j++) {
                if (str.charAt(j-1) == str2.charAt(i-1)) //문자열을 비교해 대각선값에서 +1
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                else {// 같지 않으면 바로 위의 값과 바로 왼쪽의 값에서 더 큰값으로 채운다.
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }

            }
        }

//        printMatrix(arr, str2.length() + 1, str.length() + 1);

        return max(arr,str2.length()+1,str.length()+1);
    }

}