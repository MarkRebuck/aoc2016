package com.markrebuck;

import java.io.File;
import java.util.Scanner;

/**
 * Start 8:35AM
 * Finish 8:51AM
 * Finish (part 2): 9:31AM   Once again the winners were twice as fast to solve.  Grrrr...
 *
 * I got a bit lucky here, by making a function to compute the decompressed string.
 * I had a hunch part two would involve recursion.
 * My first revision always returned the string before doing string.length(),
 * so it took a while to reswizzle it to return only the length.
 * And of course I made some silly mistakes along the way.  I need to go back on caffeine.
 */
public class AOC2016_09 {
    public static void main(String args[]) throws Exception {
        String val = "";
        Scanner scanner = new Scanner(new File("input"));
        while (scanner.hasNext()) {
            val += scanner.nextLine().trim();
        }
        System.out.println(new AOC2016_09().decompress(val, true));
    }

    public long decompress(String val, boolean isPart2) {
        int nextStart = val.indexOf('(');
        if (nextStart < 0) {
            return val.length();
        }

        long result = 0;
        while (nextStart >= 0) {
            result += nextStart;
            val = val.substring(nextStart);
            int nextEnd = val.indexOf(')', nextStart);
            if (nextEnd > 0) {
                String stub = val.substring(1, nextEnd);
                if (stub.indexOf("x") > 0) {
                    String[] pieces = stub.split(("x"));
                    int num = Integer.parseInt(pieces[0]);
                    int times = Integer.parseInt(pieces[1]);
                    val = val.substring(nextEnd + 1);
                    if (!isPart2) {
                        result += (num * times);
                    } else {
                        result += decompress(val.substring(0, num), isPart2) * times;
                    }
                    val = val.substring(num);
                }
            }
            nextStart = val.indexOf('(');
        }
        return result + val.length();
    }
}