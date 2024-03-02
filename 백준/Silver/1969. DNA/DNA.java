

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1. 모든 염기서열을 생성하여 다른 서열과 비교하기 -> X
// 2. 각각의 서열 중 가장 많이 나온 것의 서열을 픽하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, M;
    static char[][] input;
    static char[] dnaOrder = {'A', 'C', 'G', 'T'};
    static PriorityQueue<Dna> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new char[N][M];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();
        }
        String dna = "";
        int dis = 0;
        for(int i = 0; i < M;i++) {
            int[] count = new int[4];
            for(int j = 0; j < N;j++){
                for(int k = 0; k < dnaOrder.length;k++){
                    if(dnaOrder[k] == input[j][i]){
                        count[k]++;
                    }
                }
            }
            int max = 0;
            char minChar = ' ';
            for(int j = 0 ; j < count.length;j++){
                if(max < count[j]){
                    max = count[j];
                    minChar = dnaOrder[j];
                }
            }
            dna += minChar;
            dis += (N - max);
        }
        System.out.println(dna);
        System.out.println(dis);
    }

    private static class Dna implements Comparable<Dna> {

        String dna;
        int dis;

        public Dna(String dna, int dis) {
            this.dna = dna;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "Dna{" +
                    "dna='" + dna + '\'' +
                    ", dis=" + dis +
                    '}';
        }

        @Override
        public int compareTo(Dna o) {
            return this.dis - o.dis;
        }
    }
}
