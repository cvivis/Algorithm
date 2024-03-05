

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 나보다 싼게 나올때까지 구매하기
// 1차 -> 맨 마지막이 1이 아닐 수도 있다. (17점)
// 2차 -> 리터가 1000000000이 되어 수가 굉장히 크다(58점)
// 3차 -> cost자체와 중간에 연산되는과정도 BigInteger, Long타입을 넘긴다.(58점)
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] dis;
    static int[] fuel;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        dis = new int[N-1];
        fuel = new int[N];
        for(int i = 0 ; i < dis.length;i++){
            dis[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < fuel.length;i++){
            fuel[i] = Integer.parseInt(tokens.nextToken());
        }
        BigInteger cost = new BigInteger(String.valueOf(0));
        for(int i = 0; i < fuel.length-1;i++){
            int disSum = dis[i];
            int next = i+1;
            while(fuel[i] < fuel[next] && next < fuel.length-1){
                disSum+=dis[next];
                next++;
            }
            cost = cost.add(BigInteger.valueOf((long)fuel[i] * disSum));
            i = next-1;
        }
        System.out.println(cost);
    }
}
