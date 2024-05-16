
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static String str;
    static final int w = 0, o = 1, l = 2, f = 3;
    static final int MaxSize = 4;
    static int[] wolf = new int[4];
    public static void main(String[] args) throws IOException {
        str = br.readLine();
        int now = getNum(str.charAt(0));
        int result = 1;
        int correct = 0;
        for(int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            int n = getNum(c);
//            System.out.println(now + " "+n);
            if(now != n && now + 1 != n && !(now==f && n == w)){
                result = 0;
                break;
            }
            now = n;
            wolf[n]++;
            if(n == f && (i + 1== str.length() || str.charAt(i+1) == 'w')){
                for(int j = 1; j < wolf.length;j++){
                    if(wolf[w] != wolf[j]){
                        result = 0;
                        break;
                    }
                }
                wolf = new int[4];
            }
        }
        for(int j = 0; j < wolf.length;j++){
            if(wolf[w] != wolf[j]){
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
    
    private static int getNum(char c){
        if(c == 'w')return w;
        else if(c == 'o')return o;
        else if(c == 'l')return l;
        else return f;
    }
}
