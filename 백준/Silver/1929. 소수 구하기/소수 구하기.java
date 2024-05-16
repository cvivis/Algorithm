
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://ko.khanacademy.org/computing/computer-science/cryptography/comp-number-theory/v/sieve-of-eratosthenes-prime-adventure-part-4
public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int T;
    //N이 백만 O(N)이하의 시간복잡도
    // 에라토스테네스의 체

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        int A = Integer.parseInt(tokens.nextToken());
        int B = Integer.parseInt(tokens.nextToken());
        boolean[] arr = new boolean[B+1];
        arr[1] = true;
        // 하나씩 배수를 확인하는 i
        // 즉 26까지의 소수를 알고자 할때 2,3,4,5의 배수는 모두 합성수이기에 모든 25이하까지 체크
        // ex) 6의 경우 1 ~ 5까지 했기때문에 6 * 5까지는 이미 합성수로 체크되어있어 6 * 6부터 체크해줘야하지만 값이 커서 할필요 없음
        // 즉 제곱이 되는 수부터 배수 체크를 해야하는데 그 값이 주어진 B보다 크다면 굳이 할 필요가 없음
        // 따라서 제곱이 B보다 같은 범위에서 돌려야 함
        for(int i = 2; i * i <= B; i++) {
            int count = 2;
            int mulA = i;
            while(true) {
                mulA = i * count;
                count++;
                if(mulA>B)break;
                arr[mulA] = true;
            }
        }
        for(int i=A;i<=B;i++) {
            if(!arr[i]) { //위에서 방문 안했으면 소수!
                System.out.println(i);
            }
        }

    }
}
