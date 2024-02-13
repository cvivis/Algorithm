

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N;i++){
            String input = br.readLine();
            search(input);
        }
        System.out.println(output);

    }
    private static void search(String str){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i)!=' '){
                map.put(str.charAt(i)+"",map.getOrDefault(str.charAt(i)+"",0)+1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(((o1, o2) -> (map.get(o1) - map.get(o2)) * (-1)));
        if(list.size() > 1){
            if(map.get(list.get(0)) > map.get(list.get(1))){
                output.append(list.get(0));
            }
            else{
                output.append("?");
            }
        }
        else if(list.size() == 1){
            output.append(list.get(0));
        }
        else{
            output.append("?");
        }
        output.append("\n");
    }

}
