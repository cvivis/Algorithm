import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
처음 접근 : 배열을 O(N^2)를 돌려 두 용액의 합을 구하고 다시 1개의 배열과 다른 배열 사이에 투포인터 돌리기
-> 이미 두 용액이 합쳐진 것에 대한 중복처리가 힘들다.

투포인터로 접근(서칭): 하나의 값을 고정하고 각각의 고정값마다 나머지 두 용액을 투포인터로 확인한다.O(N^2)로 가능

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
        Arrays.sort(input);
        int[] result = new int[3];
        long min = Long.MAX_VALUE;
        out : for(int i = 0 ; i < N-2;i++){
            int left = i+1;
            int right = N-1;
            while(left < right){
                long sum = (long)input[i]+input[left]+input[right];
                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    result[0] = input[i];
                    result[1] = input[left];
                    result[2] = input[right];
                }
                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    result[0] = input[i];
                    result[1] = input[left];
                    result[2] = input[right];
                    break out;
                }
            }
        }
        //Arrays.sort(result);
        System.out.println(result[0]+" "+result[1]+" "+result[2]);

    }
}
