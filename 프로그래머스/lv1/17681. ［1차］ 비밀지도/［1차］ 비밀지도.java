import java.util.Arrays;

public class Solution {
    
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[][] arrBinary1 = new int[n][n];
        int[][] arrBinary2 = new int[n][n];


        for (int i = 0; i < n; i++) {
            arrBinary1[i] = makeBinary(n,arr1[i]);
        }

        for (int i = 0; i < n; i++) {
            arrBinary2[i] = makeBinary(n,arr2[i]);
        }
        // printMatrix(arrBinary1,n,n);

        for (int i = 0; i < n; i++) {
            String miro = "";
            for (int j = 0; j < n; j++) {
                if(arrBinary1[i][j]==1 || arrBinary2[i][j]==1)  miro = miro+"#";
                else{
                    miro = miro +" ";
                }
            }
            answer[i] = miro;
        }

        return answer;
    }

    public static int[] makeBinary(int n,int num) {
        int[] digits = new int[n];
        int cnt = n;

        while (true) {
            if (num < 2) {
                digits[--cnt] = num; // cnt-- 하면 n = 5 일때, index 5에서 계산시작하여 6번실행
                break;
            }

            digits[--cnt] = num % 2;
            num /= 2;
        }
        // System.out.println(Arrays.toString(digits));
        return digits;
    }

    // public static void printMatrix(int[][] arr, int num, int num2) {
    //     for (int i = 0; i < num; i++) {
    //         for (int j = 0; j < num2; j++) {
    //             System.out.printf("%s ", arr[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }
}
