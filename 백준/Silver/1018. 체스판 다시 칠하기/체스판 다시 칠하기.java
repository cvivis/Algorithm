import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int min = 64;
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(board[i].charAt(j));
//            }
//            System.out.println();
//        }

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
//                System.out.println(checkBlackBoard(board,i,j));
                int result = checkBlackBoard(board,i,j);
                min = Math.min(Math.min(result,64-result),min);
            }
        }
        System.out.println(min);

    }

    private static int checkBlackBoard(String[] arr, int row, int col){
        int min = 0;
        String[] blackBoard = {"BWBWBWBW","WBWBWBWB"};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i%2==0){
                    if(arr[row+i].charAt(col+j)!=blackBoard[0].charAt(j)) {
                        min++;
                    }
                }
                else{
                    if(arr[row+i].charAt(col+j)!=blackBoard[1].charAt(j)) {
                        min++;
                    }
                }
            }
        }
        return min;
    }
}
