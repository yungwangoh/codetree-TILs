import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        char[] ch = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }

        boolean flag = false;
        for(char c : map.keySet()) {
            if(map.get(c) == 1) {
                flag = true;
                System.out.println(c);
            }
        }

        if(!flag) System.out.println("None");
    }
}