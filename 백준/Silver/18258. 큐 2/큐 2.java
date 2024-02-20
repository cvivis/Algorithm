import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int count = Integer.parseInt(bf.readLine());
        Queue<String> queue = new LinkedList<>();//자바에서는 queue를 linkedlist에서 사용한다.
        String back  = "";
        for (int i = 0; i < count; i++) {
            String[] command = bf.readLine().split(" ");
            if(command[0].equals("push")){
                queue.add(command[1]);
                back = command[1];
            }
            else if(command[0].equals("pop")){
                if(queue.size()==0){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(queue.remove()+"\n");
                }
            }
            else if(command[0].equals("front")){
                if(queue.size()==0){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(queue.peek()+"\n");
                }
            }
            else if(command[0].equals("back")){
                if(queue.size()==0){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(back+"\n");
                }
            }
            else if(command[0].equals("size")){
                bw.write(queue.size()+"\n");
            }
            else if(command[0].equals("empty")){
                if(queue.size()==0){
                    bw.write(1+"\n");
                }
                else{
                    bw.write(0+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
