

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] arr,count;


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        init();
        int result = 0;
        for(int i = 1; i <= M;i++){
            tokens = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());
            if(!union(s,e)){
                result = i;
                break;
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(result);
    }
    private static void init(){
        arr = new int[N];
        count = new int[N];
        for(int i = 0; i < N;i++){
            arr[i] = i;
        }
    }
    private static int find(int a){
        if(a == arr[a])return a;
        return arr[a] = find(arr[a]);
    }

    private static boolean union(int a , int b){
        int na = find(a);
        int nb = find(b);
        if(na == nb)return false; 
        arr[na] = nb;
        return true;
    }

}
