

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
    static int N;
    static Map<String,Integer> map;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N;i++){
            int clothNum = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for(int j = 0; j < clothNum;j++){
                tokens = new StringTokenizer(br.readLine());
                tokens.nextToken();
                String cloth = tokens.nextToken();
                map.put(cloth,map.getOrDefault(cloth,0)+1);
            }
            int clothCnt = 1;
            for(String cloth: map.keySet()){
               clothCnt *= (map.get(cloth) + 1);
            }
            output.append(clothCnt-1+"\n");
        }
        System.out.println(output);
    }
}
