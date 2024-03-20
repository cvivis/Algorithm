

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int[] input = new int[6];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 6;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }
        int x = 0;
        int y = 0;
        done:
        for(x = -999; x <= 999;x++){
            for(y = -999; y <= 999; y++){
                boolean one = ((x * input[0] + input[1]*y) == input[2]);
                boolean other = ((x * input[3] + input[4]*y) == input[5]);
                if(one && other){
                    break done;
                }
            }
        }
//        int cal = findMin(input[0], input[3]);
//        int num1 = cal / input[0];
//        int num2 = cal / input[3];
//        input[0] = cal;
//        input[3] = cal;
//        input[1] = input[1] * num1;
//        input[2] = input[2] * num1;
//        input[4] = input[4] * num2;
//        input[5] = input[5] * num2;
//        int yNum = input[1] - input[4];
//        int normalNum = input[2] - input[5];
//        if(yNum == 0){
//
//        }
//        int y = normalNum / yNum;
//        int x = (input[2] + (y * input[1] * (-1)))/cal;
        System.out.println(x + " "+y);
    }
    private static int findMin(int a , int b){
        int max = Math.max(a,b);
        int result = Math.min(a,b);;
        int num = 1;
        while(true){
            if((result * num) % max == 0){
                break;
            }
            num++;
        }
        return result * num;
    }
}
