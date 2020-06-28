package com.dandroid.dandroidlib;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Object object;
        System.out.println("1111");
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        String str;
        Integer M, N;
        while (cin.hasNext()) {
            N = cin.nextInt();
            M = cin.nextInt();
            int grade[] = new int[N];
            for (int i = 0; i < N; i++) {
                grade[i] = cin.nextInt();
            }
            str = cin.nextLine();
            int max[] = new int[M];
            int count = 0;
            for (int i = 0; i < M; i++) {
                str = cin.nextLine();
                String[] strArray = str.split(" ");
                if (strArray[0].equals("Q")) {
                    int a = Integer.parseInt(strArray[1]);
                    int b = Integer.parseInt(strArray[2]);
                    int start = Math.min(a, b) - 1;
                    int end = Math.max(a, b);
                    max[count++] = findMax(Arrays
                            .copyOfRange(grade, start, end));
                } else if (strArray[0].equals("U")) {
                    int index = Integer.parseInt(strArray[1]);
                    int value = Integer.parseInt(strArray[2]);
                    grade[index - 1] = value;
                }
            }
            for (int j = 0; j < count; j++) {
                System.out.println(max[j]);
            }
        }
    }

    private static int findMax(int[] a) {
        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
