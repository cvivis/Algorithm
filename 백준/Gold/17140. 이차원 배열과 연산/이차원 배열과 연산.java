

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// r-1, c-1의 값 구하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int r,c,k,R = 3,C = 3;
    static int[][] A = new int[100][100];;


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        r = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < 3;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3;j++){
                A[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int time = 0;
        while(A[r-1][c-1] != k) {
            if (R >= C) calR();
            else calC();
            time++;
            if (time > 100) {
                time = -1;
                break;
            }
        }
        System.out.println(time);
//        calR();
//        for(int[] arr : A){
//            System.out.println(Arrays.toString(arr));
//        }
//        calC();
//        for(int[] arr : A){
//            System.out.println(Arrays.toString(arr));
//        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }


        @Override
        public int compareTo(Node o) {
            if(this.count == o.count) return this.num - o.num;
            return this.count - o.count;
        }
    }

    private static void calR(){
        for(int i = 0; i < R;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = 0; j < A[i].length;j++){
                if(A[i][j] != 0){
                    map.put(A[i][j],map.getOrDefault(A[i][j],0)+1);
                }
            }
            PriorityQueue<Node> pR = new PriorityQueue<>();
            Set<Integer> set = map.keySet();
            if(!set.isEmpty()){
                for(Integer num : set){
                    pR.add(new Node(num,map.get(num)));
                }
            }
            List<Integer> list = priorityCheck(pR,map.size());
            C = Math.max(C,list.size());
            A[i] = new int[100];
            for(int j = 0; j < list.size();j++){
                A[i][j] = list.get(j);
            }
        }
    }
    private static void calC(){
        for(int i = 0; i < C;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = 0; j < R;j++){
                if(A[j][i] != 0){
                    map.put(A[j][i],map.getOrDefault(A[j][i],0)+1);
                }
            }
            PriorityQueue<Node> pR = new PriorityQueue<>();
            Set<Integer> set = map.keySet();
            if(!set.isEmpty()){
                for(Integer num : set){
                    pR.add(new Node(num,map.get(num)));
                }
            }
            List<Integer> list = priorityCheck(pR,map.size());
            R = Math.max(R,list.size());
            for(int j = 0; j < R;j++){
                if(j < list.size()){
                    A[j][i] = list.get(j);
                }
                else{
                    A[j][i] = 0;
                }
            }
        }
    }
    private static List<Integer> priorityCheck(PriorityQueue<Node> input,int size){
        List<Integer> list = new ArrayList<>();
        for(int i = input.size()-1; i >= 0;i--){
            Node node = input.poll();
            list.add(node.num);
            list.add(node.count);
        }
        return list;
    }
}
