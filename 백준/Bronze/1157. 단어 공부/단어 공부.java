

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static String input;

    public static void main(String[] args) throws IOException {
        Map<Character,Integer> map = new HashMap<>();
        input = br.readLine().toUpperCase();
        for(int i = 0; i < input.length();i++){
            map.put(input.charAt(i),map.getOrDefault(input.charAt(i),0)+1);
        }
//        System.out.println(map);
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort(((o1, o2) -> (map.get(o1) - map.get(o2)) * (-1)));
        if(list.size()>1){
            if(map.get(list.get(0)) > map.get(list.get(1))){
                System.out.println(list.get(0));
            }
            else{
                System.out.println("?");
            }
        }
        else{
            System.out.println(list.get(0));
        }
    }
}
