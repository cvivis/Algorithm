
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 1차 -> 인덱스를 왼쪽부분 오른쪽 부분 따로 배열에 저장후 계산하여 풀기
// 2차 중간 인덱스를 기준으로 그냥 큐 돌리기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] arr;
    static int[][] shift;
    static int[] left;
    static int[] right;
    static int result = 0;
//    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        arr = new int[M];
        left = new int[M];
        right = new int[M];
        shift = new int[M][2];
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < M;i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
//            list.add(new Node(arr[i],arr[i] - 1,N - arr[i] + 1));
        }
        for(int i = 1; i <= N;i++){
            list.offer(i);
        }
        for(int i = 0 ; i < arr.length;i++){
            int middle = list.size()/2 ; // 까지는 left
            int count = 0;
//            System.out.println(list + " "  +result);
            if(list.indexOf(arr[i]) <= middle){ // 빼야 하는 값이 중간보다 작으면 
                while(list.peekFirst() != arr[i]){ // 계속 해당하는 부분나올때까지 밀기
                    list.offerLast(list.pollFirst());
                    count++;
                }
            }
            else{ // 반대쪽 밀기
                while(list.peekFirst() != arr[i]){
                    list.offerFirst(list.pollLast());
                    count++;
                    }
                } // 밀고 맨 왼쪽 빼기 
                list.pollFirst();
                result += count;
            }
        System.out.println(result);
    }
}
