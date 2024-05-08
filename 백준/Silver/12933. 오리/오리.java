
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static List<Integer> quacks = new ArrayList<>();
    static int q = 0, u = 1, a = 2, c = 3, k = 4;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        for(int i = 0; i < str.length();i++){
//            System.out.println(quacks);
            char sound = str.charAt(i);
            if(sound == 'q'){
                quacks.add(q);
            }
            else{
                int num = quackNum(sound);
//                if(num == -1){
//                    result = -1;
//                    break;
//                }
                boolean trigger = false;
//                System.out.println(sound+": ");
                for(int j = 0 ; j < quacks.size();j++){
                    if(quacks.get(j) == num-1){
                       quacks.set(j,num);
                       if(quacks.get(j) == k){
                           result = Math.max(result,quacks.size());
                           quacks.remove(j);
                       }
                       trigger = true;
                       break;
                    }
                }
                if(trigger)continue;
//                System.out.println(quacks);
                result = -1;
                break;
            }
        }
        if(quacks.size()>0)result = -1;
        System.out.println(result);
    }
    private static int quackNum(char sound){
        int result = -1;
        switch(sound){
            case 'q':
                result = q;
                break;
            case 'u':
                result = u;
                break;
            case 'a':
                result = a;
                break;
            case 'c':
                result = c;
                break;
            case 'k':
                result = k;
                break;
        }
        return result;
    }
}
