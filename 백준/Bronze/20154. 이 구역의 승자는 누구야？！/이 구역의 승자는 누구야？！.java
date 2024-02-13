

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] alphabet = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int sum = 0;
        for(int i = 0; i < input.length();i++){
            sum+= alphabet[(input.charAt(i) - 'A')];
        }
        int result = sum % 10;
        if(result % 2 == 1){
            System.out.println("I'm a winner!");
        }
        else{
            System.out.println("You're the winner?");
        }
    }
}
