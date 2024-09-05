import java.io.*;
import java.util.*;

// 한 노드에서 모든 노드 사이의 거리-> 다익스트라



class Solution {
    
    static class Node implements Comparable<Node>{
    int idx;
    int w;
    
    public Node(int idx, int w){
        this.idx = idx;
        this.w = w;
    }
    
    @Override
    public int compareTo(Node o){
        return this.w - o.w;
    }
    
}
    static int[] dis;
    static List<List<Integer>> graph = new ArrayList(); 
    static PriorityQueue<Node> pq = new PriorityQueue();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        dis = new int[n+1];
        for(int i = 0; i <= n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i =0; i < edge.length;i++){
            int s = edge[i][0];
            int e = edge[i][1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
    
        
        dijkstra();
        Arrays.sort(dis);
        System.out.println(Arrays.toString(dis));
        int max = 0;
        int maxCount = 0;
        for(int i = dis.length-1;i>=0;i--){
            if(dis[i] != 1000000 && max < dis[i]){
                maxCount = 1;
                max = dis[i];
            }
            
            else if(max == dis[i])maxCount++;
        }
        System.out.println(maxCount);
        return maxCount;
    }
    
    private static void dijkstra(){
        // for(int i = 0; i < dis.length;i++){
            // dis[i] = ;
        // }
        Arrays.fill(dis,1000000);
        dis[1] = 0;
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            List<Integer> nEdge = graph.get(now.idx);
            for(int i = 0; i < nEdge.size();i++){
                int nIdx = nEdge.get(i);
                int nW = now.w + 1;
                if(nW < dis[nIdx]){
                    dis[nIdx] = nW;
                    pq.add(new Node(nIdx,nW));
                }
            }
            
        }
    }
}