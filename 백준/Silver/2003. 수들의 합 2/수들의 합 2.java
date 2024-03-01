
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        arr = new int[N+1];
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while(right<=N){
            if(sum >= M){
                sum -= arr[left++]; 
            }
            else if(sum < M){
                sum += arr[right++]; // 마지막 요소를 더하고 ++ 하기에 right가 N과 같아질 수 있음 따라서 배열도 N+1로 정의 안그려면 여기서 break문 써줘야함
            }
            if(sum == M){
                count++;
            }
        }
        System.out.println(count);


//        while(left <= right){
//            if(left == right){
//                if(sum==M){
//                    count++;
//                }
//                right++;
//                if(right > arr.length-1)break;
//                sum+=arr[right];
//            }
//            else{
//                if(sum==M){
//                    count++;
//                    right++;
//                    if(right > arr.length-1)break;
//                    sum+=arr[right];
//                }
//                else if(sum < M){
//                    right++;
//                    if(right > arr.length-1)break;
//                    sum+=arr[right];
//                }
//                else{
//                    sum-=arr[left];
//                    left++;
//                }
//            }
//
//        }
    }
}
