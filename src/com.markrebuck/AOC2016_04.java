package com.markrebuck;

import java.io.File;
import java.util.Scanner;

/**
 */
public class AOC2016_04 {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(new File("input"));
        int m = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("-");
            String all = "";
            for (int i = 0; i < parts.length - 1; i++) {
                all += parts[i];
            }
            int[] count = new int[26];
            for (char c : all.toCharArray()) {
                count[c - 'a']++;
            }
            all = "";
            for (int i = 0; i < 5; i++) {
                int max = 0;
                int maxLoc = 0;
                for (int j = 0; j < 26; j++) {
                    if (count[j] > max) {
                        max = count[j];
                        maxLoc = j;
                    }
                }
                all += (char)('a' + maxLoc);
                count[maxLoc] = 0;
            }
            String last = parts[parts.length - 1];
            int pos = last.indexOf("[");
            String p1 = last.substring(0, pos);
            String p2 = last.substring(pos + 1);
            if (p2.equals(all + "]")) {
                m += Integer.parseInt(p1);
            }
        }
        System.out.println(m);
    }
}