package com.example.snippets.demo.others;

import java.io.IOException;
import java.util.Scanner;

public class AlternateChars {

    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        int countDel = 0;
        for (int i =0; i< chars.length; i++) {
            if((i+1)<chars.length && chars[i] == chars[i+1]){
                countDel++;
            }
        }
        return countDel;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
