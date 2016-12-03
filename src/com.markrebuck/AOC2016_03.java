package com.markrebuck;

import java.io.File;
import java.util.Scanner;

/**
 * --- Day 3: Squares With Three Sides ---

 Now that you can think clearly, you move deeper into the labyrinth of
 hallways and office furniture that makes up this part of Easter Bunny HQ.
 This must be a graphic design department; the walls are covered in specifications
 for triangles.

 Or are they?

 The design document gives the side lengths of each triangle it describes, but... 5 10 25?
 Some of these aren't triangles. You can't help but mark the impossible ones.

 In a valid triangle, the sum of any two sides must be larger than the remaining side.
 For example, the "triangle" given above is impossible, because 5 + 10 is not larger than 25.

 In your puzzle input, how many of the listed triangles are possible?


 */
public class AOC2016_03 {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(new File("input"));
        int legit = 0;
        while (scanner.hasNext()) {
            long s1 = scanner.nextLong();
            long s2 = scanner.nextLong();
            long s3 = scanner.nextLong();
            if (((s1 + s2) > s3)
                && ((s2 + s3) > s1)
                && ((s1 + s3) > s2))
            {
                legit++;
            }
        }
        System.out.println(legit);
    }
}