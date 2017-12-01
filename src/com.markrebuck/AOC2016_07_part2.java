package com.markrebuck;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Started         2016/12/07 7:55:20
 * Finished Part 1 2016/12/07 8:56:01 (sigh... *VERY* silly coding error caused 50 minute debug cycle!)
 */
public class AOC2016_07 {
    public static void main(String args[]) throws Exception {
        Set<String> abbas = new HashSet<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (j == i) {
                    continue;
                }
                abbas.add("" + alphabet[i] + alphabet[j] + alphabet[j] + alphabet[i]);
            }
        }
        Scanner scanner = new Scanner(new File("input"));
        int numGood = 0;
        while (scanner.hasNext()) {
            char[] line = scanner.nextLine().trim().toCharArray();
            String current = "";
            boolean hasGoodAbba = false;
            boolean hasNoBadAbba = true;
            for (char c : line) {
                final String grrr = current;
                if (c == '[') {
                    current = "";
                    if (abbas.stream().anyMatch(s -> grrr.contains(s))) {
                        //System.out.println("Good because of " + current);
                        hasGoodAbba = true;
                    }
                } else if (c == ']') {
                    current = "";
                    if (abbas.stream().anyMatch(s -> grrr.contains(s))) {
                        //System.out.println("Bad because of " + current);
                        hasNoBadAbba = false;
                        break;
                    }
                } else {
                    current += c;
                }
            }
            if (current.length() > 0) {
                final String grrr = current;
                hasGoodAbba |= abbas.stream().anyMatch(s -> grrr.contains(s));
            }
            if (hasGoodAbba && hasNoBadAbba) {
                numGood++;
            }
        }
        System.out.println(numGood);
    }
}