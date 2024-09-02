

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- 이미 정렬된 입력값 -> 이분탐색, 투포인터
- N:100000 -> O(N || NlogN)
- left != right 전까지 확인하기
* */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] input;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i = 0; i < N;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }

        int left = 0;
        int right = input.length-1;
        int bNum = input[right];
        int sNum = input[left];
        int min = Integer.MAX_VALUE;
        while(left < right){
            int num = input[left] + input[right];
            if(Math.abs(num) < min){
                min = Math.abs(num);
                bNum = input[right];
                sNum = input[left];
            }
            if(num < 0){
                left++;
            }
            else if(num > 0){
                right--;
            }
            else{
                break;
            }
        }
        System.out.println(sNum + " "+bNum);
    }
}
