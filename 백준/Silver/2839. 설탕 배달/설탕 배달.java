import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int num;
    

    public static void main(String[] args) throws IOException {
		num = Integer.parseInt(br.readLine());
		int result = -1;
		int count = 0;
		while(num!=0) {
			if(num % 5 == 0) {
				count = count + num/5;
				num = 0;
			}else {
				num -= 3;
				count++;
			}
			if(num < 0) {
				count = -1;
				break;
			}
		}
		result = count;
		
		System.out.println(result);
	}
}
