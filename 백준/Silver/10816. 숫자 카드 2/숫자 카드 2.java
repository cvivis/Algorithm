

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
    static Map<Integer,Integer> map = new HashMap(); //value, 갯수

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            int num = Integer.parseInt(tokens.nextToken());
            map.put(num, map.getOrDefault(num,0)+1);
        }
        M = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < M;i++){
            int cardNum = Integer.parseInt(tokens.nextToken());
            output.append(map.getOrDefault(cardNum,0) + " ");
        }
        System.out.println(output);
    }
}
