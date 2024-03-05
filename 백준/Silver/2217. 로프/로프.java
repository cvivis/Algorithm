import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// 1개 선택했을때 그냥 그거 자체
// 2개 선택했을때 가장 큰 무게 중 2개 골라서 그 중 제일 작은거에 * 2가 최대
// 3개 선택했을 때 가장 큰 무게 들 중 3개에서 그 중 제일 작은 거 * 3가 최대 
// 정렬 후 1개 선택 시0번째 * 1, 2개 선택 시 1 번째 * 2...
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        for(int i = 0 ; i < N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int max = 0;
        for(int i = 0; i < N;i++){
            int temp = arr[i] * (i+1);
            if(max < temp)max = temp;
        }
        System.out.println(max);
    }


}
