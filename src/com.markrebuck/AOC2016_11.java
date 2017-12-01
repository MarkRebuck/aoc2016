package com.markrebuck;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Start 12:05PM
 * Finish 12:45PM.  Misread the problem, and was NOT coding well!
 * Finish (part 2): 12:59.  Took me a while to realize I couldn't exist until outputs
 *                          0, 1, and 2 were all full.  So I just dumped the outputs
 *                          and inspected by hand.
 *
 *  Wouldn't have been in top 100 for either star.
 */
public class AOC2016_10 {
    Map<Integer, Integer> lows = new HashMap<>();
    Map<Integer, Integer> highs = new HashMap<>();
    Map<Integer, Integer> outputs = new HashMap<>();

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(new File("input"));
        new AOC2016_10().doIt(scanner);
    }

    public void doIt(Scanner scanner) {
        List<String[]> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine().split(" "));
        }
        for(;;) {
        for (String[] parts : lines) {
            if (parts[0].equals("value")) {
                int value = Integer.parseInt(parts[1]);
                int target = Integer.parseInt(parts[5]);
                Integer low = lows.get(target);
                if (low == null) {
                    lows.put(target, value);
                } else {
                    highs.put(target, Math.max(low, value));
                    lows.put(target, Math.min(low, value));
                }
            }
        }
            for (String[] parts : lines) {
                // bot 109 gives low to bot 188 and high to bot 13
                if (parts[0].equals("bot")) {
                    int source = Integer.parseInt(parts[1]);
                    String lowTargetName = parts[5];
                    int lowTarget = Integer.parseInt(parts[6]);
                    String highTargetName = parts[10];
                    int highTarget = Integer.parseInt(parts[11]);
                    Integer low = lows.get(source);
                    Integer high = highs.get(source);
                    if ((low == null) || (high == null)) {
                        continue;
                    }
                    lows.remove(source);
                    highs.remove(source);
                    System.out.println(source + " " + lowTarget + " " + highTarget + " low=" + low);
                    if (lowTargetName.equals("output")) {
                        outputs.put(lowTarget, low);
                    } else {
                        give(low, lowTarget);
                    }
                    if (highTargetName.equals("output")) {
                        outputs.put(highTarget, high);
                    } else {
                        give(high, highTarget);
                    }
                }
                for (Integer key : lows.keySet()) {
                    Integer low = lows.get(key);
                    Integer high = highs.get(key);
                    if ((low == null) || (high == null)) {
                        continue;
                    }
                    if ((low == 17) && (high == 61)) {
                        System.out.println(key);
                        System.out.println(lows);
                        System.out.println(highs);
                        //System.exit(0);
                    }
                }
                System.out.println(outputs); // outputs.get(0) + " " + outputs.get(1) + " " + outputs.get(2));
            }
        }
    }

    public void give(int amount, int target) {
        Integer low = lows.get(target);
        Integer high = highs.get(target);
        List<Integer> nums = new ArrayList<>();
        if (low != null) {
            nums.add(low);
        }
        if (high != null) {
            nums.add(high);
        }
        nums.add(amount);
        Collections.sort(nums);
        lows.put(target, nums.get(0));
        highs.put(target, nums.get(nums.size() - 1));
    }
}