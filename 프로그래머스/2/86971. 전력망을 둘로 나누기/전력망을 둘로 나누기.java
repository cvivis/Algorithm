

import java.util.Arrays;

public class Solution {
    static boolean[][] visit;
    static int[] leafCount;
    static int[] parentsPath;
    static int allCount = 0;
    static int[] dp;
    public static int solution(int n, int[][] wires) {
        int answer = -1;
        visit = new boolean[n+1][n+1];
        leafCount = new int[n+1];
        parentsPath = new int[n+1];
        dp = new int[n+1];
        findLeaf(n,wires);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length;i++){
            int temp = leafCount[n];
            int x = wires[i][0];
            int y = wires[i][1];
            if(parentsPath[x] == y){
                temp = leafCount[n] - leafCount[x];
                min = Math.min(min,Math.abs(leafCount[x] - temp));
            }
            else if(parentsPath[y] == x){
                temp = leafCount[n] - leafCount[y];
                min = Math.min(min,Math.abs(leafCount[y] - temp));
            }
        }
//        System.out.println(min);
        return min;
    }
    public static void findLeaf(int n , int[][] wires){

        for(int i = 0; i < wires.length;i++){
                int x = wires[i][0];
                int y = wires[i][1];
                visit[x][y] = true;
                visit[y][x] = true;
        }
        parentsPath[n] = -1;
        dfs(n,n);
//        System.out.println(Arrays.toString(parentsPath));
        System.out.println(Arrays.toString(leafCount));
    }
    public static int dfs(int  n, int x){
        int count = 1;
        for(int i = 1; i <= n;i++){
            if(visit[x][i]){
//                count++;
                visit[x][i] = false;
                visit[i][x] = false;
                count += dfs(n,i);
                parentsPath[i] = x;
            }
        }

        leafCount[x] = count;
        return count;
//        allCount += count;
//        System.out.println(x + " : "+ allCount);
    }
}
