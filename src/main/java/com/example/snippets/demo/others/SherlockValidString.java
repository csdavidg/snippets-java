package com.example.snippets.demo.others;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockValidString {

    static String isValid(String s) {
        List<String> wordArr = Arrays.asList(s.split(""));
        Map<String, Long> lettersMap = wordArr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Long, Long> timesMap = lettersMap.values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long[] times = timesMap.keySet().toArray(new Long[0]);

        long deleteAdditional = 0;
        if (timesMap.size() > 2) {
            return "NO";
        } else if(timesMap.size() == 1){
            return "YES";
        }else if (timesMap.get(times[0]) > 1 && timesMap.get(times[1]) > 1) {
            // 1 - 4
            // 2 - 5
            return "NO";
        } else if (timesMap.get(times[0]) > timesMap.get(times[1])) {
                deleteAdditional = times[1] - 1;
                if(deleteAdditional == 0 || deleteAdditional == times[0]){
                    return "YES";
                }
            }else{
                deleteAdditional = times[0] - 1;
                if(deleteAdditional == 0 || deleteAdditional == times[1]){
                    return "YES";
                }
            }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}
