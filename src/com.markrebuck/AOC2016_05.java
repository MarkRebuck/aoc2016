package com.markrebuck;

import java.math.BigInteger;
import java.security.MessageDigest;

/**

 */
public class AOC2016_05 {
    public static void main(String[] args) throws Exception {
        final String left = "reyedfim";
        long right = 0;
        MessageDigest md = MessageDigest.getInstance("MD5");
        char[] full = "--------".toCharArray();
        for (; ; ) {
            final String combined = left + right;
            byte[] bytes = combined.getBytes("UTF-8");
            byte[] digest = md.digest(bytes);
            BigInteger bigInt = new BigInteger(1,digest);
            String hashtext = bigInt.toString(16);
            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }
            if (hashtext.startsWith("00000")) {
                System.out.println(right + "->" + hashtext);
                int pos = -1;
                pos = hashtext.charAt(5) - '0';
                if ((pos < 8) && (pos >= 0)) {
                    char c = hashtext.charAt(6);
                    if (full[pos] == '-') {
                        full[pos] = c;
                        if (new String(full).indexOf("-") == -1) {
                            System.out.println(new String(full));
                            System.exit(0);
                        }
                    }
                    System.out.println(new String(full));
                }
            }
            right++;
            if (0 == (right % 100000)) {
                System.out.println(right);
            }
        }
    }
}