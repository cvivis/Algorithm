import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = step1(new_id);
        new_id = step2(new_id);
//        System.out.println(new_id);
        new_id = step3(new_id);
//        System.out.println(new_id);
        new_id = step4(new_id);
//        System.out.println(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);
        return new_id;
    }
    private static String step1(String new_id){
        return new_id.toLowerCase();
    }
    private static String step2(String new_id){
        return new_id.replaceAll("[^\\w\\-_.]*", "");
    }
    private static String step3(String new_id){
        return new_id.replaceAll("\\.{2,}",".");
    }
    private static String step4(String new_id){
        return new_id.replaceAll("^[.]|[.]$", "");

    }

    private static String step5(String new_id){
        if(new_id.length() == 0){
            new_id = "a";
        }
        return new_id;
    }

    private static String step6(String new_id){
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        return new_id;
    }
    private static String step7(String new_id){
        if(new_id.length()<=2){
            while(new_id.length()<3){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }

}