package com.markrebuck;

import java.io.File;
import java.util.Scanner;

/**
 */
public class AOC2016_04_part2 {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(new File("input"));
        int m = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("-");
            String word = "";
            for (int i = 0; i < parts.length - 1; i++) {
                word += parts[i];
            }
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            String all = "";
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
            int sector = Integer.parseInt(p1);

            String p2 = last.substring(pos + 1);
            if (p2.equals(all + "]")) {
                m += Integer.parseInt(p1);
                String foo = "";
                for (char c : word.toCharArray()) {
                    foo += ((char) ('a' + ((c - 'a' + sector) % 26)));
                }
                if (foo.startsWith("northpole")) {
                    System.out.println(word);
                    System.out.println(sector);
                }
            }
        }
        System.out.println(m);
    }
}