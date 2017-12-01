package com.markrebuck;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Start 8:00AM
 * Finish
 * Finish (part 2):
 *
 */
public class AOC2016_11 {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(new File("input"));
        new AOC2016_11().doIt(scanner);
    }

    public void doIt(Scanner scanner) {
        List<String[]> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine().split(" "));
        }
        for (String[] parts : lines) {
        }
    }
}