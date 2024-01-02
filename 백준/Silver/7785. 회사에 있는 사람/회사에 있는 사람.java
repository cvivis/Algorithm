import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            String name = tokens.nextToken();
            String info = tokens.nextToken();
            if(info.equals("enter")){
                set.add(name);
            }
            else{
                if(set.contains(name)){
                    set.remove(name);
                };
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list,Collections.reverseOrder());
        for(int i = 0; i < list.size();i++){
            output.append(list.get(i)+"\n");
        }
        System.out.println(output);
    }
}
