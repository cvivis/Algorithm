import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static Set<Integer> set = new TreeSet<>();
    static int[] input;
    static int[] value;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        input = new int[N];
        value = new int[N];
        for(int i = 0;i<N;i++){
            int num = Integer.parseInt(tokens.nextToken());
            set.add(num);
            value[i] = num;
        }

        Iterator iter = set.iterator();
        int i = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(iter.hasNext()){
            int num = (int)iter.next();
            map.put(num,i++);
        }

//        System.out.println(Arrays.toString(input));
        for(int num : value){
            output.append(map.get(num)+" ");
        }
        System.out.println(output);


    }
}
