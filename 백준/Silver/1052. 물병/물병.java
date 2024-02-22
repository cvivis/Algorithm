
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,K;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        int num = N;
        int result = 0;

        while(Integer.bitCount(num)>K){ // bit에서 1의 갯수가 K보다 크면
            String binary = Integer.toBinaryString(num); // ex) 110과 같이 표현
            for(int i = binary.length()-1;i>=0;i--){ //뒤에서 부터 읽어서 1인 비트만큼 더해주기 반복 
                if(binary.charAt(i)=='1'){
                    int bottle = 1 << (binary.length() - i - 1);
                    num += bottle;
                    result += bottle;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
