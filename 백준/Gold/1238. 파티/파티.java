
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    public static List<ArrayList<Node>> graph1 = new ArrayList<>();
    public static List<ArrayList<Node>> graph2 = new ArrayList<>();
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static Integer[] dist;
    static int N, M, start;
    // 그래프의 노드
    private static class Node {
        int w;
        int from;
        int to;

        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "w=" + w +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    // pq로 비교할 누적값이 저장된 요소
    private static class Element implements Comparable<Element> {
        int dist, index;

        public Element(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }

        @Override
        public int compareTo(Element e) {
            return this.dist - e.dist;   // dist 기준 오름차순 정렬
        }
    }
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        start = Integer.parseInt(tokens.nextToken());
        //초기화
        for(int i = 0; i <= N;i++){
            graph1.add(new ArrayList<Node>());
        }

        for(int i = 0; i < M;i++){
            tokens = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int w = Integer.parseInt(tokens.nextToken());
            // 양방향이면 2개 해줘야됨
            graph1.get(from).add(new Node(from,to,w));
        }
        Integer[] dist1 = dijkstra(graph1);



        for(int i = 0; i <= N;i++){
            graph2.add(new ArrayList<Node>());
        }
        for(int i = 1; i <= N;i++){
            for(int j = 0; j < graph1.get(i).size();j++){
                int from = graph1.get(i).get(j).from;
                int to = graph1.get(i).get(j).to;
                int w = graph1.get(i).get(j).w;
                graph2.get(to).add(new Node(to,from,w));
            }
        }
        Integer[] dist2 = dijkstra(graph2);
        int max = 0;
        for(int i = 1 ; i <= N;i++){
            max = Math.max(max , dist1[i] + dist2[i]);
        }
        System.out.println(max);
//        System.out.println(Arrays.toString(dist1));
//        System.out.println(Arrays.toString(dist2));
    }
    private static Integer[] dijkstra(List<ArrayList<Node>> graph){
        // 다익스트라.
        dist = new Integer[N+1];
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        // 거리가 가까운 곳이 먼저 나와야 하며
        // 해당 지점이 어디인지에 대한 정보도 필요하므로
        // (거리, 정점 번호) 형태로 넣어줘야 합니다.
        pq = new PriorityQueue<>();
        pq.add(new Element(0,start));

        // O(|E|log|V|) 다익스트라 코드
        // 우선순위 큐에
        // 원소가 남아있다면 계속 진행해줍니다.
        while(!pq.isEmpty()){
            Element now = pq.poll();

            // 우선순위 큐를 이용하면
            // 같은 정점의 원소가
            // 여러 번 들어가는 문제가 발생할 수 있어
            // minDist가 최신 dist[minIndex]값과 다르다면
            // 계산할 필요 없이 패스해줍니다.
            if(now.dist != dist[now.index])continue;
            for(int i = 0; i < graph.get(now.index).size();i++){
                int target = graph.get(now.index).get(i).to;
                int w = graph.get(now.index).get(i).w;

                // 현재 위치에서 연결된 간선으로 가는 것이 더 작다면
                if(dist[now.index] + w < dist[target]){
                    // 값을 갱신해주고, 우선순위 큐에 해당 정보를 넣어줍니다.
                    dist[target] = dist[now.index] + w;
                    pq.add(new Element(dist[now.index] + w,target));
                }
            }
        }
        return dist;
    }
}



