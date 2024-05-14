import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static char[] answer,input;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = br.readLine().toCharArray();
        answer = br.readLine().toCharArray();
        char[] startZero = Arrays.copyOf(input,input.length);
        turnOn(startZero,0);
        int cnt1 = greedy(startZero,1);
        int cnt2 = greedy(input,0);
//        System.out.println(cnt1 + " "+ cnt2);
        int result = Math.min(cnt1,cnt2);
        if(result == Integer.MAX_VALUE){
            result = -1;
        }
        System.out.println(result);
    }
    private static int greedy(char[] arr,int startCnt){
        int cnt = startCnt;
        for(int i = 1; i <= arr.length-1;i++){
            if(arr[i-1] != answer[i-1]){
                turnOn(arr,i);
                cnt++;
            }
        }
        if(String.valueOf(arr).equals(String.valueOf(answer)))return cnt;
        return Integer.MAX_VALUE;
    }
    private static void turnOn(char[] arr,int idx){
        for(int i = idx-1; i <= idx+1;i++){
            if(i >= N || i < 0)continue;
            arr[i] = (arr[i] == '1'? '0' : '1');
        }
    }
}
