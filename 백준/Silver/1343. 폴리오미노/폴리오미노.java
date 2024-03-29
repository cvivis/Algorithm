
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static char[] input;

    public static void main(String[] args) throws IOException {
        input = (br.readLine()+".").toCharArray(); // 마지막 처리를 위해 .붙이기
        int count = 0;
        boolean check = false;
        for(int i = 0; i < input.length;i++){
            if(input[i] == 'X'){
                count++;
            }
            else{// .이 나올때 문자 대체하기
                while(count > 1){
                    if(count - 4 >= 0){
                        output.append("AAAA");
                        count-=4;
                    }
                    else if(count - 2 >= 0){
                        output.append("BB");
                        count-=2;
                    }
                }
                if(count == 1){ // 1개가 남으면 될 일이 없음
                    check = true;
                    break;
                }
                output.append(".");
                count = 0;
            }
        }
        if(check){
            System.out.println("-1");
        }
        else{
            output.delete(output.length()-1,output.length());
            System.out.println(output);
        }
    }


}
