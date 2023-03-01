import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, start;
    static int[][] input;
    static int[] visited;
    static int max;

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]++;
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i = 1; i < input.length;i++){
//                System.out.println(input[num][i]);
//                System.out.println(visited[i]);
                if(visited[i]==0 && input[num][i] == 1){

                    queue.offer(i);
                    visited[i] = visited[num]+1;
                }
            }
        }
//        System.out.println(Arrays.toString(visited));
    }

    public static void main(String[] args) throws IOException {
        int t;
        for (t = 1; t <= 10; t++) {
            tokens = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokens.nextToken());
            start = Integer.parseInt(tokens.nextToken());
            input = new int[101][101];
            tokens = new StringTokenizer(br.readLine());
            visited = new int[101];
            max = Integer.MIN_VALUE;
            for (int i = 1; i <= N/2; i++) {
                int from = Integer.parseInt(tokens.nextToken());
                int to = Integer.parseInt(tokens.nextToken());

//                System.out.println(from);
//                System.out.println(to);

                input[from][to] = 1;
//                System.out.println(Arrays.toString(input[from]));
            }
//            for(int[] arr : input){
//                System.out.println(Arrays.toString(arr));
//            }
            bfs();
            int maxNum = 0;
            for(int i = 1; i< visited.length;i++){
                if(maxNum <= visited[i]){
                    max = i;
                    maxNum = visited[i];
                }
            }
            output.append("#" + t + " "+max+"\n");

        }
        System.out.println(output);
    }
}
