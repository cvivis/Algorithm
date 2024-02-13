

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N;i++){
            String str = br.readLine();
            boolean result = check(str);
            if(result){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static boolean check(String str){
        char c = str.charAt(0);
        for(int i = 1; i < str.length();i++){
            if(c != str.charAt(i)){
                for(int j = 0; j < i-1;j++){
                    if(str.charAt(i) == str.charAt(j)){
                        return false;
                    }
                }
            }
            c = str.charAt(i);
        }
        return true;
    }
}
