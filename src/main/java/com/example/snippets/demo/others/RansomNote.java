package com.example.snippets.demo.others;

import java.util.Hashtable;
import java.util.Scanner;


public class RansomNote {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();

        /*String mag = "two times three is not four";
        String ran = "two times two is four";

        String[] magazine = mag.split(" ");
        String[] ransome = ran.split(" ");

        checkMagazine(magazine, ransome);*/

    }

    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> magazineTable = new Hashtable<>();

        for (String word : magazine) {
            if(magazineTable.containsKey(word)){
                Integer amount = magazineTable.get(word)+1;
                magazineTable.put(word, amount);
            }else{
                magazineTable.put(word, 1);
            }
        }

        String response = "No";
        boolean notFound = false;
        for (String word : note) {
            if(magazineTable.containsKey(word)){
                Integer amount = magazineTable.get(word)-1;
                if(amount == 0){
                    magazineTable.remove(word);
                }else {
                    magazineTable.put(word, amount);
                }
            } else {
                notFound = true;
                break;
            }
        }
        if(!notFound){
            response = "Yes";
        }
        System.out.println(response);

    }
}
