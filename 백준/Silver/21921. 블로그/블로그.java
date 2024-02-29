

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,X;
    static int[] arr;
    static Queue<Integer> window = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        X = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        arr = new int[N];

        int sum = 0;
        for(int i = 0; i < N;i++){ // 입력받기
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        for(int i = 0; i < X;i++){ // 시작 윈도우 만들기
            window.add(arr[i]);
            sum += arr[i];
        }
        int max = sum;
        count = 1; // 최댓값 갯수
        for(int i = X; i < N;i++){ // 윈도우 다음값부터 확인
            sum -= window.poll(); // 첫번째 윈도우 빼고
            window.add(arr[i]); // 뒤에 넣기
            sum += arr[i]; 
            if(max < sum){ //최대값이 바뀌면 갱신해주기
                max = sum;
                count = 1; 
            }
            else if(max == sum){ 
                count++;
            }
        }
        if(max == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
