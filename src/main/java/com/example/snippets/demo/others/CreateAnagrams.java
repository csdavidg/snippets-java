package com.example.snippets.demo.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> values = new HashMap<>();
        for (Character letter : a.toCharArray()) {
            int ct = values.getOrDefault(letter, 0);
            values.put(letter, (ct + 1));
        }

        for (Character letter : b.toCharArray()) {
            int ct = values.getOrDefault(letter, 0);
            values.put(letter, (ct - 1));
        }
        return values.values().stream().mapToInt(Math::abs).sum();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}
