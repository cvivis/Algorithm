

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 다익스드라로 N까지의 최단 경로를 뽑기
// 최단경로내의 엣지를 다 없에보며 지연시간 구하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] dist;
    static int[] firstPath;
    static boolean first = true;
    static int time = 0;
    static List<ArrayList<Node>> graph = new ArrayList<>();
    static class Node{
        int from;
        int to;
        int w;
        boolean use;

        public Node(int from, int to, int w,boolean use) {
            this.from = from;
            this.to = to;
            this.w = w;
            this.use = use;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "from=" + from +
                    ", to=" + to +
                    ", w=" + w +
                    ", use=" + use +
                    '}';
        }
    }
    static class Element implements Comparable<Element>{
        int id;
        int sum;

        public Element(int id, int sum) {
            this.id = id;
            this.sum = sum;
        }

        @Override
        public int compareTo(Element o) {
            return this.sum - o.sum;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "id=" + id +
                    ", sum=" + sum +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i <= N;i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < M; i++){
            tokens = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int w = Integer.parseInt(tokens.nextToken());
            graph.get(from).add(new Node(from,to,w,true));
            graph.get(to).add(new Node(to,from,w,true));
        }
        dijkstra();
        int from = N;
        int delay = Integer.MIN_VALUE;
        while(true){
            int to = firstPath[from];
            Node a = new Node(0,0,0,true);
            Node b = new Node(0,0,0,true);
            for(int i = 0; i < graph.get(from).size();i++){
                if(graph.get(from).get(i).to == to){
                    a = graph.get(from).get(i);
                    break;
                }
            }
            for(int i = 0; i < graph.get(to).size();i++){
                if(graph.get(to).get(i).to == from){
                    b = graph.get(to).get(i);
                    break;
                }
            }
//            System.out.println(a + " "+ b);
            a.use = false;
            b.use = false;
            dijkstra();
            a.use = true;
            b.use = true;
            int nTime = dist[N];
//            System.out.println("nTime : "+nTime);
            if(nTime == (int)1e9){
                delay = -1;
                break;
            }
            else{
                delay = Math.max(delay,nTime - time);
            }
//            System.out.println("delay: "+delay);
            from = to;
            if(from == 0)break;
        }
        System.out.println(delay);
    }
    private static void dijkstra(){
        dist = new int[N+1];
        Arrays.fill(dist,(int)1e9);
        dist[1] = 0;
        int[] path = new int[N+1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(1,0));
        while(!pq.isEmpty()){
            Element now = pq.poll();
            if(now.sum != dist[now.id])continue;
            for(int i = 0; i < graph.get(now.id).size();i++){
                Node next = graph.get(now.id).get(i);
                if(next.use && now.sum + next.w < dist[next.to]){
                    dist[next.to] = now.sum + next.w;
                    pq.add(new Element(next.to,dist[next.to]));
                    path[next.to] = now.id;
                }
            }
        }
//        System.out.println("dist: "+Arrays.toString(dist));
        if(first){
            firstPath = path.clone();
            time = dist[N];
            first = false;
        }
//        System.out.println(Arrays.toString(path));
//        System.out.println(Arrays.toString(dist));
    }
}
