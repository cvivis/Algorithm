

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static List<BigInteger> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i<N;i++){
            String str = br.readLine();
            StringBuilder temp = new StringBuilder();
            boolean trigger = false;
            for(int j = 0; j < str.length();j++){
                if(str.charAt(j) - 'A' < 0){
//                    System.out.println(str.charAt(j));
                    trigger = true;
                    temp.append(str.charAt(j));
                }
                else{
                    if(temp.length() > 0 && trigger){
//                        System.out.println(temp);
                        trigger = false;
                        BigInteger big = new BigInteger(String.valueOf(temp));
                        list.add(big);
                        temp.setLength(0);
                    }
                }
            }
            if(temp.length() > 0){
//                        System.out.println(temp);
                BigInteger big = new BigInteger(String.valueOf(temp));
                list.add(big);
            }

        }
        Collections.sort(list);
        for(BigInteger num : list){
            System.out.println(num);
        }
    }
}
