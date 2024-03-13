import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[][] input;
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        input = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N;i++){
            tokens = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++){
                input[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        find(0,0);
        System.out.println(min);
    }
    private static boolean isIn(int x , int y){
        return x > 0 && y > 0 && x < N-1 && y < N-1;
    }
    private static boolean visitCheck(int x, int y){
        if(visit[x+1][y])return false;
        else if(visit[x][y])return false;
        else if(visit[x-1][y])return false;
        else if(visit[x][y-1])return false;
        else if(visit[x][y+1])return false;
        else{
            return true;
        }
    }

    private static void visit(int x, int y , boolean check){
        visit[x+1][y] = check;
        visit[x][y] = check;
        visit[x-1][y] = check;
        visit[x][y-1] = check;
        visit[x][y+1] = check;

    }
    private static int sumCheck(int x , int y){
        return input[x][y] + input[x+1][y] + input[x-1][y] + input[x][y-1] + input[x][y+1];
    }

    private static void find(int cnt,int sum ){
        if(cnt == 3){
            if(min > sum){
                min = sum;
            }
            return;
        }
        for(int i = 1; i < N-1;i++){
            for(int j = 1; j < N-1;j++){
                int middleX = i;
                int middleY = j;
                if(isIn(middleX,middleY) && visitCheck(middleX,middleY)){
                    int price = sumCheck(middleX,middleY);
                    visit(middleX,middleY,true);
                    find(cnt+1,sum+price);
                    visit(middleX,middleY,false);
                }
            }
        }
    }
}
