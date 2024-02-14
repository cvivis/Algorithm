

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] input;
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 1, 9}, {3, 9, 1}, {1, 3, 9}, {1, 9, 3}};
    static int count = Integer.MAX_VALUE;
    static int[][][] visit = new int[61][61][61];


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = new int[3];
        tokens = new StringTokenizer(br.readLine());
//        for(int i = 0 ; i < 61;i++){
//            for(int j = 0; j < 61;j++){
//                for(int k = 0; k < 61;k++){
//                    visit[i][j][k] = Integer.MAX_VALUE;
//                }
//            }
//        }
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(tokens.nextToken());
        }
//        Arrays.sort(input);
        find(0, input[0], input[1], input[2]);
        System.out.println(count);
    }


    private static void find(int cnt, int a, int b, int c) {
        if (a <= 0 && b <= 0 && c <= 0) {
            if (count > cnt) {
                count = cnt;
            }
            return;
        }
        for (int i = 0; i < attack.length; i++) {
            int na = a - attack[i][0];
            int nb = b - attack[i][1];
            int nc = c - attack[i][2];
            if (na < 0) na = 0;
            if (nb < 0) nb = 0;
            if (nc < 0) nc = 0;

//            System.out.println(visit[na][nb][nc]);
            if (visit[na][nb][nc] != 0) {
                if(visit[na][nb][nc] > cnt+1){
                    visit[na][nb][nc] = cnt+1;
                    find(cnt + 1, na, nb, nc);
                }
//                System.out.println(cnt+" "+a+" "+b+" "+c + "abc");
//                System.out.println(cnt+" "+na+" "+nb+" "+nc+"nnnabc");
            }
            else{
                visit[na][nb][nc] = cnt+1;
                find(cnt + 1, na, nb, nc);
            }

        }
    }
}
