import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 1. set을 이용해 수의 중복처리를 해준뒤 바로 직전 수와 새로추가할 값이 쌍이 앞전 선택과 같은지 비교한다.
2. 사전 순 증가이기에 문자열로 처리한다.
* */
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] arr,input;
    static boolean[] visit;
    static Set set = new LinkedHashSet();
    private static void find(int idx){
        if(idx == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length;i++){
//                System.out.println(Arrays.toString(arr));
                sb.append(arr[i] + " ");

            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i <input.length;i++){
            if(!visit[i]){
                arr[idx] = input[i];
                visit[i] = true;
                find(idx+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N];
        visit = new boolean[N];
        arr = new int[M];
        tokens = new StringTokenizer(br.readLine());
        for(int i  = 0; i < N;i++){
            input[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(input);
        find(0);
        set.forEach(System.out::println);
//        System.out.println(output + "\n");
    }


}
