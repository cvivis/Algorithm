import java.util.*;
class Solution {
    static boolean[][] visit;
    static int[][] loc = {{-1,0},{0,1},{1,0},{0,-1}};
    static int R,C;
    static int sizeLand = 0;
    static int[][] landById;
public static int solution(int[][] land) {
        int answer = 0;
        R = land.length;
        C = land[0].length;
        visit = new boolean[R][C];
        landById = land;
        int idx = 2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < R;i++){
            for(int j = 0; j < C;j++){

                if(!visit[i][j] && land[i][j] == 1){
                    sizeLand = 1;
                    findSize(i,j,idx);
                    map.put(idx++,sizeLand);
                }
            }
        }
//        System.out.println("map: "+map);
        Set<Integer> set = new HashSet<>();
//        for(int[] arr : landById){
//            System.out.println(Arrays.toString(arr));
//        }
        int sum = 0 ;
        for(int i = 0; i < C;i++){
            set = new HashSet<>();
            for(int j = 0; j < R;j++){
                if(landById[j][i] >= 2){
                    set.add(landById[j][i]);
                }
            }
            sum = 0;
//            System.out.println("set: "+set);
            if(!set.isEmpty()){
                for(int id : set){
                    sum += map.get(id);
                }     
            }
//            System.out.println(sum);
            if(answer < sum){
                answer = sum;
            }
        }



        return answer;
    }
    public static boolean isIn(int x , int y){
        return x >= 0 && y >= 0 && x < R && y < C;
    }
    public static void findSize(int x , int y,int id){
        landById[x][y] = id;
//        System.out.println(x + " "+ y);
//        System.out.println("id : "+id + " size: "+size);

        for(int i = 0; i < loc.length;i++){
            int nx = x + loc[i][0];
            int ny = y + loc[i][1];
            if(isIn(nx,ny) && !visit[nx][ny] && landById[nx][ny] == 1){
                visit[nx][ny] = true;
                sizeLand++;
                findSize(nx,ny,id);
            }
        }
    }
}