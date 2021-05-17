package com.example.snippets.demo.streams;

import org.apache.tomcat.jni.Local;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.function.DoubleToIntFunction;
import java.util.function.ToIntFunction;

public class PrimitivesSpecialized {


    public static void main(String[] args) throws ParseException {
        DoubleToIntFunction dtoIntFunc = x -> (int) (x*10);
        System.out.println(dtoIntFunc.applyAsInt(10.12));

        ToIntFunction<Character> charToInt = x -> x.compareTo('C');
        System.out.println(charToInt.applyAsInt('X'));

        Optional<String> optString = Optional.of("VALUE");
        Optional<Integer> optInt = optString.map(String::length);

        int c = 10;
        assert (c = 1) == 10 : "c is not equals to 1";
        System.out.println("C is " + c);

        LocalTime time = LocalTime.of(10, 40, 50, 1209);
        System.out.println(" TIME IS " + time);

        ZonedDateTime zDate = ZonedDateTime.now();

        System.out.println(zDate);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'The Month MMM is: ' MMM");
        System.out.println(date.format(formatter));


        Locale locale = Locale.getDefault();
        System.out.println("Locale: "+locale);

        String s = "40.45";

        var en = NumberFormat.getInstance(Locale.US);
        System.out.println(en.parse(s));  // 40.45

        var fr = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(fr.parse(s));  // 40

        Locale colombianLocale = new Locale.Builder()
                .setLanguage("es")
                .setRegion("CO")
                .build();

        var local = NumberFormat.getInstance(colombianLocale);
        System.out.println(" LOCAL " + local.parse(s));



    }


}
