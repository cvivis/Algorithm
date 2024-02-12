

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 길이가 100만이기 때문에 문자열 검색 알고리즘을 사용할 필요가 있다.
// 이문제는 KMP, 라빈 커브를 사용할 수 있는듯하다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int[] fail;
    static String sub,input;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        sub = br.readLine();
//        System.out.println(sub);
//        System.out.println(sub.length());
        fail = new int[sub.length()];
        getFail();
        search();
        if(result > 0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

    // 팰린드롬 되는 구간 찾기
    private static void getFail(){
        int j = 0;
        for(int i = 1; i <sub.length();i++){
            while(j > 0 && sub.charAt(j) != sub.charAt(i)){
                j = fail[j-1]; // 마지막으로 일치했던 인덱스로 다시 가서 검사
            }
            if(sub.charAt(i) == sub.charAt(j)){
                fail[i] = ++j;
            }
        }
    }

    private static void search(){
        int j = 0;
        for(int i = 0; i < input.length();i++){
            while( j > 0 && input.charAt(i) != sub.charAt(j)){
                j = fail[j-1];
            }
            if(input.charAt(i) == sub.charAt(j)){
                if(j == sub.length()-1){
                    j = fail[j]; // 찾아도 계속 찾기
                    result++;
                }else{
                    j++;
                }
            }
        }
    }
}
