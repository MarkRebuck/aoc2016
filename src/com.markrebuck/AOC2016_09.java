package com.markrebuck;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Start 8:07AM
 * Finish 8:36AM (sigh...  Leaderboard ended at 22:55)
 *
 * Lost ~10 minutes because I was rotating the wrong way.
 *
 * Got lucky and already dumped the screen for part one,
 * so for part two I only had to look at my screen and type
 * the answer :)
 */
public class AOC2016_08 {
    public static void main(String args[]) throws Exception {
        final int width = 50;
        final int height = 6;
        boolean[][] board = new boolean[height][width];
        Scanner scanner = new Scanner(new File("input"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            System.out.println(Arrays.toString(parts));
            if (line.startsWith("rect")) {
                String[] pieces = parts[1].split("x");
                int x = Integer.parseInt(pieces[0]);
                int y = Integer.parseInt(pieces[1]);
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        board[j][i] = true;
                    }
                }
            } else if (line.startsWith("rotate row")) {
                String[] pieces = parts[2].split("=");
                int row = Integer.parseInt(pieces[1]);
                int by = Integer.parseInt(parts[4]);
                boolean[] nextRow = new boolean[width];
                for (int x = 0; x < width; x++) {
                    nextRow[(x + by) % width] = board[row][x];
                }
                for (int x = 0; x < width; x++) {
                    board[row][x] = nextRow[x];
                }
            } else if (line.startsWith("rotate column")) {
                String[] pieces = parts[2].split("=");
                int col = Integer.parseInt(pieces[1]);
                int by = Integer.parseInt(parts[4]);
                boolean[] nextCol = new boolean[height];
                for (int y = 0; y < height; y++) {
                    nextCol[(y + by) % height] = board[y][col];
                }
                for (int y = 0; y < height; y++) {
                    board[y][col] = nextCol[y];
                }
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    System.out.print(board[y][x] ? '#' : '-');
                }
                System.out.println();
            }
        }

        //  There is probably a lovely streaming version of this,
        //  but I can't find a BooleanStream and it is too late
        //  to make the board int[][].  Oops.
        int count = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (board[y][x]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}