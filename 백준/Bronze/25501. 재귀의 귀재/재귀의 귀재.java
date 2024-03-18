

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
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            cnt = 0;
            boolean result = recursion( br.readLine(),1);
            if(result){
                System.out.println(1 + " "+ cnt);
            }else{
                System.out.println(0 + " "+cnt);
            }

        }
    }
    private static boolean recursion(String str , int count){
        cnt = count;
        if(str.length()<=1){
            return true;
        }
        else{
            if(str.charAt(0) == str.charAt(str.length()-1)){
                return recursion(str.substring(1,str.length()-1),count+1);
            }
            else{
                return false;
            }
        }

    }

}
