import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Map<Character, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            String player = br.readLine();
            map.put(player.charAt(0),map.getOrDefault(player.charAt(0),0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(Character c : list){
            if(map.get(c) >= 5){
                output.append(c);
            }
        }
        if(output.length()==0){
            System.out.println("PREDAJA");
        }
        else{
            System.out.println(output);
        }
    }
}
