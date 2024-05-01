

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
*
5 4
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3
3 4
8 1
4 8

*
* */
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static int[][] input;
    static int[][] move;
    static int[][] delta = {{100,100},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static int[][] cloudLoc ;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        input = new int[N][N];
        move = new int[M][2];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int i = 0; i < M;i++){
            tokens = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(tokens.nextToken());
            move[i][1] = Integer.parseInt(tokens.nextToken());
        }
        cloudLoc = new int[][]{{N-1, 0}, {N-1, 1}, {N - 2, 0}, {N - 2, 1}};

        for(int i = 0; i < move.length;i++){
//            for(int[] arr : input){
//                System.out.println(Arrays.toString(arr));
//            }
//            System.out.println("-------------------before");
            bibaragi(move[i][0],move[i][1]);
//            for(int[] arr : input){
//                System.out.println(Arrays.toString(arr));
//            }
//            System.out.println("-------------------after");
        }
        int sum = 0;
        for(int i = 0; i < N;i++){
            for(int j = 0;j<N;j++){
                sum += input[i][j];
            }
        }
        System.out.println(sum);

    }
    private static boolean isIn(int x, int y){
        return x > -1 && y > -1 && x < N && y < N;
    }
    private static void bibaragi(int d,int s){
        int[][] temp2 = new int[N][N];
        for(int i = 0; i < cloudLoc.length;i++){
            temp2[cloudLoc[i][0]][cloudLoc[i][1]] = 1;
        }
//        System.out.println("=================== 구름 이동 전");
//        for(int[] arr : temp2){
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println("===================");
//        for(int[] arr : cloudLoc){
//            System.out.println(Arrays.toString(arr));
//        }
        for(int i = 0; i < cloudLoc.length;i++){ // 구름 이동 후 물 증가
            int nx = (N + cloudLoc[i][0] + (delta[d][0])*s%N)%N;
//            System.out.println(cloudLoc[i][0] + " "+ cloudLoc[i][1] + " " + d + " " + s );
            int ny =  (N + cloudLoc[i][1] + (delta[d][1])*s%N)%N;
            cloudLoc[i][0] = nx;
            cloudLoc[i][1] = ny;
            input[cloudLoc[i][0]][cloudLoc[i][1]]++;
//            System.out.println(cloudLoc[i][0] + " "+ cloudLoc[i][1]);
        }
//       temp2 = new int[N+1][N+1];
//        for(int i = 0; i < cloudLoc.length;i++){
//            temp2[cloudLoc[i][0]][cloudLoc[i][1]] = 1;
//        }
//        System.out.println("=================== 구름 이동 후");
//        for(int[] arr : temp2){
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println("===================");


        for(int i = 0; i < cloudLoc.length;i++){ // 대각선 물증가
            int count = 0;
            for(int j = 0;j<delta.length;j = j+2){
                if(j != 0){
                    int nx = cloudLoc[i][0] + delta[j][0];
                    int ny = cloudLoc[i][1] + delta[j][1];
                    if(isIn(nx,ny) && input[nx][ny] > 0)count++;
                }
            }
            input[cloudLoc[i][0]][cloudLoc[i][1]] += count;
        }
        List<int[]> tempCloud = new ArrayList<>();
        for(int i = 0; i < N;i++){
            for(int j = 0; j < N;j++){
                if(input[i][j] >= 2){
                    tempCloud.add(new int[]{i,j});
                }
            }
        }
//        for(int[] arr : cloudLoc){
//            System.out.println(Arrays.toString(arr));
//        }
        for(int i = tempCloud.size()-1; i >= 0;i--){
            int x = tempCloud.get(i)[0];
            int y = tempCloud.get(i)[1];
            for(int j = 0; j < cloudLoc.length;j++){
                if(cloudLoc[j][0] == x && cloudLoc[j][1] == y){
//                    System.out.println(x + " "+y);
                    tempCloud.remove(i);
                }
            }

        }
        int[][] newCloud = new int[tempCloud.size()][2];
        for(int i = 0; i < tempCloud.size();i++){
            newCloud[i][0] = tempCloud.get(i)[0];
            newCloud[i][1] = tempCloud.get(i)[1];
            input[newCloud[i][0]][newCloud[i][1]] -=2;
        }
        cloudLoc = newCloud;
//        int[][] temp = new int[N+1][N+1];
//        for(int i = 0; i < cloudLoc.length;i++){
//            temp[cloudLoc[i][0]][cloudLoc[i][1]] = 1;
//        }
//        System.out.println("===================");
//        for(int[] arr : temp){
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println("===================");
    }

}
