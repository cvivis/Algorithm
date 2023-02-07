import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int n;
    static int[] mySwitch;
    static int student;

    public static void doSwitch(int idx) {
        mySwitch[idx] = mySwitch[idx] == 0 ? 1 : 0;
    }

    public static boolean isIn(int idx, int count) {
        return idx - count >= 1 && idx + count <= mySwitch.length - 1;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        mySwitch = new int[n + 1];
        tokens = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            mySwitch[i] = Integer.parseInt(tokens.nextToken());
        }
        student = Integer.parseInt(br.readLine());
        int[][] students = new int[student][2];
        for (int i = 0; i < student; i++) {
            tokens = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(tokens.nextToken());
            students[i][1] = Integer.parseInt(tokens.nextToken());
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i][0] == 1) { // 남자
                int num;
                int count = 1;
                while (true) {
                    num = students[i][1] * count;
                    if (num >= mySwitch.length) break;
                    doSwitch(num);
                    count++;
                }
            } else {
                int idx = students[i][1];
                int count = 0;
                while (true) {
                    if (isIn(idx, count+1) && mySwitch[idx - (count+1)] == mySwitch[idx + count+1]) {
                        count++;
                    } else {
                        break;
                    }
                }
                for (int j = idx - count; j <= idx + count; j++) {
                    doSwitch(j);
                }
            }
//            System.out.println(Arrays.toString(Arrays.copyOfRange(mySwitch,1,mySwitch.length)));
        }
        for(int i=1; i<mySwitch.length; i++) {
            output.append(mySwitch[i]+" ");
            if(i%20 ==0) output.append("\n");
        }
//        output.append(mySwitch[mySwitch.length - 1]);
        System.out.println(output);
    }

}
