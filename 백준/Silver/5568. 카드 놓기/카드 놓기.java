

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static int[] input;
    static int[] select;
    static boolean[] visit;
    static Set<Integer> set = new HashSet<>();
    // 순열
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(br.readLine());
        input = new int[N];
        for(int i = 0; i < N;i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        select = new int[K];
        visit = new boolean[N];
        find(0);
        System.out.println(set.size());
    }
    private static void find(int cnt){
        if(cnt == K){
//            System.out.println(Arrays.toString(select));
            String str = "";
            for(int i = 0; i < select.length;i++){
                str+=select[i];
            }
            set.add(Integer.parseInt(str));
            return;
        }
        for(int i = 0; i < input.length;i++){
            if(!visit[i]){
                select[cnt] = input[i];
                visit[i] = true;
                find(cnt+1);
                visit[i] = false;
            }
        }
    }
}
