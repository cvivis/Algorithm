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
    static int S,E,Q;
    static Map<String,Boolean> map = new HashMap<>();
    static int result;
    static String str;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        S = getTime(tokens.nextToken().split(":"));
        E = getTime(tokens.nextToken().split(":"));
        Q = getTime(tokens.nextToken().split(":"));
        while( (str = br.readLine()) != null){

            tokens = new StringTokenizer(str);
//            System.out.println(tokens +" ----");
//                String time = tokens.nextToken();
//            System.out.println(time);
            int time = getTime(tokens.nextToken().split(":"));
                String name = tokens.nextToken();
//                System.out.println(time + " "+ name);
            if(time<=S){
                map.put(name,true);
            }
            else if(time >= E && time <= Q){
                if(map.getOrDefault(name,false)){
                    result++;
                    map.put(name,false);
                }
            }
            }
        System.out.println(result);
    }
    private static int getTime(String[] time){
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
