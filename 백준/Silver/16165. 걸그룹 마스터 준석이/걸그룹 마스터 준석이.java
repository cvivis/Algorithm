

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static Map<String,String> members = new HashMap<>();
    static Map<String, List<String>> groups = new HashMap<>();
    static int N,M;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < N;i++){
            String group = br.readLine();
            int groupCnt = Integer.parseInt(br.readLine());
            List<String> memberList = new ArrayList<>();
            for(int j = 0; j < groupCnt;j++){
                String member = br.readLine();
                members.put(member,group);
                memberList.add(member);
            }
            Collections.sort(memberList);
            groups.put(group,memberList);
        }
        for(int i = 0; i < M;i++){
            String question = br.readLine();
            int kind = Integer.parseInt(br.readLine());
            if(kind == 1){
                output.append(members.get(question)+"\n");
            }
            else{
                for(String m :groups.get(question)){
                    output.append(m+"\n");
                }
            }
        }
        System.out.println(output);

    }
}

