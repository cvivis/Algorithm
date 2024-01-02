import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Map<String, Integer> books = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            String input = br.readLine();
            books.put(input, books.getOrDefault(input,0)+1);
        }
        int max = 0;
        String maxBook = "";
        for(String key :books.keySet()){
           if(books.get(key)>max){
               maxBook = key;
               max = books.get(key);
           }
        }
        System.out.println(maxBook);
    }
}
