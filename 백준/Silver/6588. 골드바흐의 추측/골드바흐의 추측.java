
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 소수테이블을 만들고
// 1000000 만 이하의 짝수들중 가장 작은 소수를 빼고 나머지도 소수인것을 검증하는 배열을 만들자
// 한번에 모든 짝수의 홀수의 소수 합을 구하는 minus arr를 만들어서 진행 -> 8% 시간초과
// 주어진 테스트케이스는 10만개로 한번에 천만개 구하기 보다 그때그때 구해서 10만개 구하는것이 더 효율적
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static boolean[] prime = new boolean[1000001];
    static int[] minus = new int[1000001];
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        findPrime();
        while(true){
            int input = Integer.parseInt(br.readLine());
            String str = "Goldbach's conjecture is wrong.";
            if(input == 0){
                break;
            }
            for(int i = 3;i<input;i++){
                if(!prime[i] && !prime[input - i]){
                    str = input + " = " + i + " + "+ (input - i);
                    break;
                }
            }
            output.append(str+"\n");
        }
        System.out.println(output);
    }

    private static void findPrime(){
        for(int i = 2; i * i <= 1000000;i++){
            int mul = 2;
            int num = i;
            while(num * mul <= 1000000){
                prime[num * mul] = true;
                mul++;
            }
        }
    }
    // 한번에 만들기
   //    private static void findMinusPrime(){
//        for(int i = 6;i<=100000;i++){
//            for(int j = 3; j <= i;j++){
//                if(!prime[j]&&!prime[i - j]){
//                    minus[i] = j;
//                    break;
//                }
//            }
//        }
//    }

}
