import java.io.*;
import java.util.*;

public class Main {

    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();

            for(int j = 0; j < n; j++) {
                String s = sc.next();
                int num = sc.nextInt();

                if(s.equals("I")) {
                    enQueue(num);
                } else if(s.equals("D")) {
                    if(!set.isEmpty()) {
                        if(num > 0) {
                            deQueueMax(num);
                        } else {    
                            deQueueMin(num);
                        }
                    }
                }
            }

            if(set.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(set.last() + " " + set.first());
                }

                set.clear();
        }
    }
    static void enQueue(int x) {
        set.add(x);
    }
    static void deQueueMin(int x) {
        int num = set.first();
        set.remove(num);
    }
    static void deQueueMax(int x) {
        int num = set.last();
        set.remove(num);
    } 
}