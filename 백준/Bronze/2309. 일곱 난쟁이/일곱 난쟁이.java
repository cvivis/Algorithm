import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int[] dwarf = new int[7];
	static int[] result = new int[7];
	static int[] input;
	
	public static void find(int count,int start) {
		if(count == 7) {
			int sum = 0;
			for(int num:dwarf) {
				sum+=num;
			}
			if(sum==100) result = Arrays.copyOfRange(dwarf, 0, dwarf.length);
				return;
		}
		for(int i = start;i<9;i++) {
			dwarf[count] = input[i];
			find(count+1,i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input = new int[9];
		for(int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		find(0,0);
		Arrays.sort(result);
		for(int i = 0; i < 7; i++) {
			output.append(result[i]+"\n");
		}
		System.out.println(output);
		
	}

}

