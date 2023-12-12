import java.io.*;
import java.util.*;

public class Main {

    static int t, m;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            m = sc.nextInt();
            for(int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }


            findMedian();
            System.out.println();
        }
    }
    static void findMedian() {

        int median = arr[0];
        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>();
        System.out.print(median + " ");

        for(int i = 1; i < m; i++) {

            if(i % 2 == 1) {
                if(arr[i] < median) 
                    maxQ.add(-arr[i]);
                else 
                    minQ.add(arr[i]);
            } else {
                int newCand;
                if(maxQ.size() > minQ.size()) {
                    newCand = -maxQ.poll();
                } else {
                    newCand = minQ.poll();
                }

                int[] a = new int[]{median, arr[i], newCand};
                Arrays.sort(a);

                maxQ.add(-a[0]);
                median = a[1];
                minQ.add(a[2]);

                System.out.print(median + " ");
            }
        }
    }
}