

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static Map<Integer,Integer> map = new HashMap<>();
    static int result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            int num = Integer.parseInt(tokens.nextToken());
            if(map.getOrDefault(M - num,0)!=0){
                map.put(M-num,map.get(M-num)-1);
                result++;
            }
            else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        System.out.println(result);

    }
}
