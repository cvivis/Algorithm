import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int gap;
	static boolean[] isVisited;
	static int T;
	static int[][] input;
	
	public static void findSub(int cnt) {
		if(cnt == T) {
			int sum = 0;
			int mul = 1 ;
			for(int i = 0; i<T;i++) {
				if(isVisited[i]) {
					sum+=input[i][1];
					mul*=input[i][0];
				}
			}

			if(gap > Math.abs(sum-mul) && sum != 0 && mul!=1) {
				gap = Math.abs(sum-mul);
			}
			return;
		}
		isVisited[cnt] = true;
		findSub(cnt+1);
		isVisited[cnt] = false;
		findSub(cnt+1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		T = Integer.parseInt(br.readLine());
		input = new int[T][2];
		isVisited = new boolean[T];
		for(int i =0;i<T;i++) {
			tokens = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(tokens.nextToken());
			input[i][1] = Integer.parseInt(tokens.nextToken());
		}
		gap = Math.abs(input[0][0] - input[0][1]);
		findSub(0);
		System.out.println(gap);
		
		
	}

}
