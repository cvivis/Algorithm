

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int result;
    static List<String> list = new ArrayList<>();
    static Map<String , Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            map.put(br.readLine(),1);
        }
        for(int i = 0; i < M;i++){
            String name = br.readLine();
            if(map.getOrDefault(name,0) != 0){
                result++;
                list.add(name);
            }
        }
        Collections.sort(list);
        output.append(result+"\n");
        for(String name : list){
            output.append(name+"\n");
        }
        System.out.println(output);

    }
}
