import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 각 리스트의 최대 오리 글자의 숫자를 갱신하느 방식
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
            if(sound == 'q'){ // 새 오리 추가
                quacks.add(q);
            }
            else{ // 다른 경우에는 
                int num = quackNum(sound);
                boolean trigger = false;
                for(int j = 0 ; j < quacks.size();j++){
                    if(quacks.get(j) == num-1){ // 나머지는 오리 최대값 갱신 
                       quacks.set(j,num);
                       if(quacks.get(j) == k){ // 마지막이면 오리 사이즈 갱신
                           result = Math.max(result,quacks.size());
                           quacks.remove(j);
                       }
                       trigger = true;
                       break;
                    }
                }
                if(trigger)continue; // 순서에 맞지 않는 오리 소리
                result = -1;
                break;
            }
        }
        if(quacks.size()>0)result = -1;
        System.out.println(result);
    }
    // c -> 내가 지정한 int 형 변환
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
