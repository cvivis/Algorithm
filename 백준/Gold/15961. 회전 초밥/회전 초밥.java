import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N,d,k,c;
//	static Set<Integer> set = new HashSet<>();
	static int[] idxArr ;
	static int max,cnt;
	static int[] input; 
	static Deque<Integer> window = new LinkedList<Integer>();
	
	public static int find() {
		int cnt = 0;
		for(int num:idxArr) {
			if(num>0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		d = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		
		idxArr = new int[d+1];
		input = new int[N+1+k];
		idxArr[c]++;
		cnt = 1;
		
		for(int i = 1; i <= N;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <= k;i++) {
			input[N+i] = input[i];
		}
		
		for(int i = 1; i <= k;i++) {
			if(++idxArr[input[i]] == 1) {
				cnt++;
			}
		}
		
		max = cnt;
		for(int i = k+1; i <= N+k;i++) {
			if(++idxArr[input[i]] == 1) {
				cnt++;
			}
			if(--idxArr[input[i-k]] == 0) {
				cnt--;
			}
			if(max < cnt) max = cnt;
		}
		System.out.println(max);
		
	}
}