package com.example.snippets.demo.others;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
            /*bufferedWriter.write(result);
            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();

        scanner.close();
    }

    public static Set<Character> getCharSet(String word) {
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        return set;
    }

    static String twoStrings(String s1, String s2) {

        Set<Character> set1 = getCharSet(s1);
        Set<Character> set2 = getCharSet(s2);

        set1.retainAll(set2);

        if(set1.isEmpty()){
            return "NO";
        }

        return "YES";
    }
}
