

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int S,B;
    static int[] deltas = {2,-1,1};
//    static Map<Integer,Integer> map = new HashMap<>();// 어느 시간 도착 몇번
    static int count = 0;
    static int[] visit;
    static int time = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        S = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());
        visit = new int[100001];
        Arrays.fill(visit,Integer.MAX_VALUE);
        if(S != B){
            Bfs();
            System.out.println(time);
            System.out.println(count);
        }
        else{
            System.out.println(0);
            System.out.println(1);
        }
    }

    private static class Node{
        int loc;
        int time;

        public Node(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }

    private static boolean isIn(int x){
        return x >= 0 && x <= 100000;
    }

    private static void Bfs(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(S,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i < deltas.length;i++){
                int nx;
                if(deltas[i] == 2){
                    nx = now.loc * deltas[i];
                }else{
                    nx = now.loc + deltas[i];
                }
                if(isIn(nx)){
                    if(nx == B){
                        // 최소값 비교
                        if(time>now.time+1){
                            time = now.time+1;
                            count = 1;
                        }
                        else if(time == now.time+1){
                            count++;
                        }
                    }
                    else{
                        if(visit[nx] >= now.time+1){
                            queue.offer(new Node(nx,now.time+1));
                            visit[nx] = now.time+1;
                        }
                    }
                }

            }

        }
    }
}
