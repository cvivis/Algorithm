import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] nodeList;
    static class node{
        int node;
        int cnt;
        String allNode;

        public node(int node,int cnt ,String allNode) {
            this.node = node;
            this.cnt = cnt;
            this.allNode = allNode;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[N+1];
        for(int i = 0 ; i <=N ; i++)nodeList[i] = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> { //x = 좌표, y= 번호
            return o1.x - o2.x;
        });
        pq.add(new Point(-10000000,0));
        pq.add(new Point(10000000,0));
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.add(new Point(x-r,k));
            pq.add(new Point(x+r,k));
        }
        makeTree(pq,-1);

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        boolean visit[] = new boolean[N+1];
        Queue<node> que = new LinkedList<>();
        visit[from] = true;
        que.add(new node(from,1,""+from));
        while(!que.isEmpty()){
            node now = que.poll();
            if(now.node == to){
                System.out.println(now.cnt);
                System.out.println(now.allNode);
                return;
            }
            for(int next : nodeList[now.node]){
                if(visit[next])
                    continue;
                visit[next]= true;
                que.add(new node(next, now.cnt+1,now.allNode+" "+next));
            }
        }
    }

    static void makeTree(PriorityQueue<Point> pq,int parents ){
        Point now = pq.poll();
        if(parents != -1) {
            nodeList[parents].add(now.y);
            nodeList[now.y].add(parents);
        }
        while(now.y != pq.peek().y){
            makeTree(pq,now.y);
        }
        pq.poll();
    }
}