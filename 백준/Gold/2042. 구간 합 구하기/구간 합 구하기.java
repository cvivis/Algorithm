import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N,M,K;
	static long[] tree;
	
	private static void update(int idx, long num) {
		
		while(idx < tree.length) {
			tree[idx] += num;
			idx +=  idx & -idx;
		}
	}
	
	private static long getSum(int idx) {
		long sum = 0;
		while(idx > 0) {
//			System.out.println(idx);
			sum +=tree[idx];
			idx &= idx-1;
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		tree = new long[N+1];
		for (int i = 1; i <= N; i++) {
			long num = Long.parseLong(br.readLine());
//			System.out.println("asdf");
			update(i,num);
//			System.out.println(Arrays.toString(tree));
		}
		
		for(int i = 1; i <= M+K;i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			if(a == 1) {
				long c = Long.parseLong(tokens.nextToken());
				update(b,c-(getSum(b) - getSum(b-1)));
			}
			else if(a == 2) {
				int c = Integer.parseInt(tokens.nextToken());
				System.out.println(getSum(c) - getSum(b-1));
			}
		}
		
	}
}
