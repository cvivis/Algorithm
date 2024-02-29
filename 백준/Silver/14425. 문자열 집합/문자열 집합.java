

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
    static Map<String, Boolean> map = new HashMap<>();
    static int result;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            map.put(br.readLine(),true);
        }
        for(int j = 0; j < M;j++){
            String str = br.readLine();
            if(map.getOrDefault(str,false)){
                result++;
            }
        }
        System.out.println(result);
    }
}
