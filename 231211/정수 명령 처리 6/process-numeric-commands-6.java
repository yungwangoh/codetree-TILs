import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Queue<Integer> queue = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            if(s.equals("push")) {
                int x = sc.nextInt();
                push(-x);
            } else if(s.equals("size")) {
                System.out.println(size());
            } else if(s.equals("pop")) {
                System.out.println(pop());
            } else if(s.equals("empty")) {
                System.out.println(empty());
            } else {
                System.out.println(top());
            }
        }
    }
    static void push(int x) {
        queue.add(x);
    }
    static int size() {
        return queue.size();
    }
    static int pop() {
        return -queue.poll();
    }
    static int empty() {
        if(queue.isEmpty()) return 1;
        else return 0;
    }
    static int top() {
        return -queue.peek();
    }   
}