

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        output.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
//        output.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n" +
//                "\"재귀함수가 뭔가요?\"\n" +
//                "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
//                "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
//                "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\n");
        answer(0);
//        output.append("라고 답변하였지.");
        System.out.println(output);
    }
    private static void answer(int cnt){
        String stick = "";
        for(int i = 0 ; i < cnt;i++){
            stick += "____";
        }
        if(cnt == N){
            output.append(stick + "\"재귀함수가 뭔가요?\"\n");
            output.append(stick + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            output.append(stick + "라고 답변하였지.\n");
            return;
        }
        else{
            output.append(stick + "\"재귀함수가 뭔가요?\"\n");
            output.append(stick + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            output.append(stick + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            output.append(stick + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            answer(cnt+1);
            output.append(stick + "라고 답변하였지.\n");
        }
    }
}
