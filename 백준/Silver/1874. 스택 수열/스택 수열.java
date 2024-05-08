import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 주어진 스택 수열 구현하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N;
    static int[] input;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        for(int i = 0; i < N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        int num = 1; // 넣어야 할 수 
        int arrIdx = 0; // 주어진 수열 배열의 idx
        while(arrIdx<input.length && num <= N){ 
            if(stack.empty()){ // 스택이 비었으면 수 넣어주고 다음수++
                stack.push(num);
                num++;
                output.append("+\n");
            }
            else{
                int top = stack.peek(); 
                if(top == input[arrIdx]){ // 스택에 값이 있으면 수열의 수인지 아닌지 확인
                    stack.pop(); 
                    arrIdx++;
                    output.append("-\n");
                }
                else{ // 해당하는 값이 아닐경우 
                    if(top<input[arrIdx]){ // 값이 작으면 그냥 다음 수 넣어주기 
                        stack.push(num);
                        num++;
                        output.append("+\n");
                    }else{ // 반례가 왜생기는지 모르지만 이경우가 있음 여기서 NO해줘도 될듯
                        break;
                    }
                }
            }
        }
        // 스택에 주어진 N까지 Push가 다 되어있는상태로 남은 수열배열 확인하기
        for(int i = stack.size();i>=0 ;i--){ 
                if(stack.peek() == input[arrIdx]){ // stack이 비었으면 null 예외가 나오기에 안에서 break
                    output.append("-\n");
                    stack.pop(); 
                    if(stack.empty())break;
                    arrIdx++;
                }
                else{ // 값이 수열과 다르면 그냥 안되는거!
                    output.setLength(0);
                    output.append("NO");
                    break;
                }
        }
        System.out.println(output);
    }
}
