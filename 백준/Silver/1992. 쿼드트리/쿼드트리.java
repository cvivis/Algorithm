import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static char[][] input;


    public static char find(int x,int y,int num) {//배열 섞였나 확인
        char press = input[x][y];
//        System.out.println(x + " - " + y + " - " +num );
        for(int i = x; i <x + num ; i++) {
            for(int j = y; j < y + num;j++) {
//                System.out.println(press + " : " + input[i][j]);
                if(press != input[i][j]) {
                    return '?';
                }
            }
        }
//        System.out.println(press);
        return press;
    }

    public static void press(int x,int y,int num) { // 시작점, 길이
        if(num == 0)return ;
//		System.out.println(num);
        output.append("(");
        int half = num/2;

        char press = find(x,y,half);
//        System.out.println("왼1"+press);
        if(press == '?') {
            press(x,y,half);
        }
        else {
            output.append(press);
        }

//        System.out.printf("%d %d %d\n",x,y+half,half);
        press = find(x , y +half,half);
//        System.out.println("우1"+press);
        if(press == '?') {
            press(x,y+half,half);
        }
        else {
            output.append(press);
        }
        press = find(x+half , y,half);
//        System.out.println("왼2"+press);
        if(press == '?') {
            press(x+half,y,half);
        }
        else {
            output.append(press);
        }

        press = find(x+half , y +half,half);
//        System.out.println("우2"+press);
        if(press == '?') {
            press(x+half,y+half,half);
        }
        else {
            output.append(press);
        }
        output.append(")");

    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            input[i] = s.toCharArray();
//            System.out.println(Arrays.toString(input[i]));

        }
//        System.out.println(input[0][3]);


            press(0,0,N);
        if(!output.toString().contains("1")){
            System.out.println("0");
        }
        else if(!output.toString().contains("0")){
            System.out.println("1");
        }
        else{
            System.out.println(output);
        }


//		for (char[] nums : input) {
//			System.out.println(Arrays.toString(nums));
//		}
    }
}

