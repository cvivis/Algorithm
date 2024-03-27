

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visit;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        visit = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 0; i <= N;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1;i++)
        {
            tokens = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        find();
        for(int i = 2; i < parent.length;i++){
            System.out.println(parent[i]);
        }
//        System.out.println(Arrays.toString(parent));
    }
    private static void find(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visit[1] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < list.get(now).size();i++){
                int next = list.get(now).get(i);
                if(!visit[next]){
                    queue.offer(next);
                    parent[next] = now;
                    visit[next] = true;
                }
            }
        }
    }
}
