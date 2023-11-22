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
    static String convert(String s) {

        char[] str = new char[s.length()];

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                str[i] = (char) (list.get(s.charAt(i) - 'a') + '0');
            } else {
                str[i] = s.charAt(i);
            }   
        }

        return new String(str);
    }
    static void recur(int idx, String s) {
        if(idx == 6) {
            int sum = 0;
            String result = convert(s);
            //System.out.println(result);

            max = Math.max(max, calculate(result));

            return;
        }

        for(int i = 1; i <= 4; i++) {
            list.add(i);
            recur(idx + 1, s);
            list.remove(list.size() - 1);
        }
    }
    static int calculate(String s) {
        
        int sum = (int) (s.charAt(0) - '0');

        for(int i = 1; i < s.length(); i += 2) {
            char oper = s.charAt(i);
            int next = (int) (s.charAt(i + 1) - '0');

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