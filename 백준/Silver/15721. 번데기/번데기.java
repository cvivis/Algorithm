

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int A,T,num;
    static int[] frame = {0,1,0,1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        boolean word = (num==0 ? false:true);
        int cnt = 2;
        int idx = 0;
        int turn = 1;
        boolean now = false;

        loop:
        while(true){
            now = false;
            for(int i = 0; i < 4;i++){
                if(turn == T && now == word){
//                    System.out.println("1111");
                    break loop;
                }else{
                    now = !now;
                    idx++;
                }
                if(i % 2 == 1)turn++;
            }
            for(int i = 0; i < cnt;i++){
                now = false;
                if(turn == T && now == word){
//                    System.out.println("2222");
                    break loop;
                }else{
                    idx++;
                    turn++;
                }
            }
            turn -= cnt;
            for(int i = 0; i < cnt;i++){
                now = true;
                if(turn == T && now == word){
//                    System.out.println("3333");
                    break loop;
                }else{
                    idx++;
                    turn++;
                }
            }
            cnt++;
        }
        System.out.println(idx%A);
    }
    private static void find(int cnt, int loop,int idx){
        if(cnt > 10000){
            return;
        }
        if(cnt == T){
            result = idx;
            return;
        }
        idx++;

    }

}
