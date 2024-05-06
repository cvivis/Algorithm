

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


//플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 생성하고 입장시킨다. 이떄 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능하다.
//입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기시킨다.
//이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.
//방의 정원이 모두 차면 게임을 시작시킨다.
// 구현 : 방 , 플레이어 클래스 생성 , 방은 리스트로 지정 해당  방안에 플레이어도 리스트로 저장
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int p,m;
    static List<Room> roomList = new ArrayList<>();
    static final boolean START = true , WAIT = false;
    static class Room{
        int levelStandard;
        boolean status;
        List<Player> players;

        public Room(int levelStandard, boolean status, List<Player> players) {
            this.levelStandard = levelStandard;
            this.status = status;
            this.players = players;
        }
    }
    static class Player implements Comparable<Player>{
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }


        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(br.readLine());
        p = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        for(int i = 0; i < p;i++){
            tokens = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(tokens.nextToken());
            String n = tokens.nextToken();
            addPlayer(new Player(l,n));
        }
        for(int i = 0; i < roomList.size();i++){
            Room room = roomList.get(i);
            if(room.status == START){
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }
            Collections.sort(room.players);
            for(int j = 0; j < room.players.size();j++){
                System.out.println(room.players.get(j).level + " "+room.players.get(j).name);
            }
        }
    }
    private static void addPlayer(Player p){
        boolean check = false; // 입장 여부
        for(int i = 0; i < roomList.size();i++){
            Room room = roomList.get(i);
            if(room.status == WAIT && (room.levelStandard + 10 >= p.level && room.levelStandard - 10 <= p.level)){
                room.players.add(p);
                check = true;
                if(room.players.size() == m){
                    room.status = START;
                }
                break;
            }
        }
        if(!check){
            roomList.add(new Room(p.level,WAIT,new ArrayList<>()));
            roomList.get(roomList.size()-1).players.add(p);
            if(roomList.get(roomList.size()-1).players.size() == m){
                roomList.get(roomList.size()-1).status = START;
            }
        }
    }
}
