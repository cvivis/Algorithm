import java.util.*;
class Solution {

//    static List<Boolean> list = new ArrayList<>();
    public int solution(int n, int k) {
        int answer = 0;
        String str = change(n,k);
        String[] nums = str.split("0");
        for(int i = 0; i < nums.length;i++){
            if(nums[i].length() == 0){
                nums[i] = "1";
            }
        }
                for(int i = 0;i<nums.length;i++){
                    if(eratos(Long.parseLong(nums[i])))answer++;
                }
        return answer;
    }
    public static boolean eratos(long n){
        if(n == 1) return false;
        for(long i = 2; i*i<=n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public String change(int n,int k){
        StringBuilder temp = new StringBuilder();
        while(n>=k){
            temp.insert(0,n % k);
            n /= k;
        }
        temp.insert(0,n);
        return temp.toString();
    }


}