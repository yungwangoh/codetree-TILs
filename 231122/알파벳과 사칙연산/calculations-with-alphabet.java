import java.io.*;
import java.util.*;

public class Main {

    static final int ASCII = 128;
    static int max = Integer.MIN_VALUE;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        recur(0, s);

        System.out.println(max);
    }
    static void recur(int idx, String s) {
        if(idx == 6) {

            max = Math.max(max, calculate(s));

            return;
        }

        for(int i = 1; i <= 4; i++) {
            list.add(i);
            recur(idx + 1, s);
            list.remove(list.size() - 1);
        }
    }
    static int calculate(String s) {
        
        int sum = list.get((int) (s.charAt(0) - 'a'));

        for(int i = 1; i < s.length(); i += 2) {
            char oper = s.charAt(i);
            int next = list.get((int) (s.charAt(i + 1) - 'a'));

            if(oper == '+') {
                sum += next;
            } else if(oper == '-') {
                sum -= next;
            } else {
                sum *= next;
            }
        }

        return sum;
    }
}