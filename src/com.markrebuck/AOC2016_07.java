package com.markrebuck;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Yuck... Wasted 10:23 on part one solving the wrong problem.
 * Once I read the problem correctly, it only took 4:32.
 */
public class AOC2016_06 {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(new File("input"));
        List<char[]> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine().trim().toCharArray());
        }
        for (int i = 0; i < 8; i++) {
            int[] counts = new int[26];
            for (char[] chars : lines) {
                counts[chars[i] - 'a']++;
            }
            int max = -1;
            int maxLoc = -1;
            for (int j = 0; j < 26; j++) {
                if (counts[j] > max) {
                    max = counts[j];
                    maxLoc = j;
                }
            }
            System.out.print("abcdefghijklmnopqrstuvwxyz".charAt(maxLoc));
        }
        System.out.println("\n");
    }
}