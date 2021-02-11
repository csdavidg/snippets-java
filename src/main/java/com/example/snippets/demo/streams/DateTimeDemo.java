package com.example.snippets.demo.streams;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

public class DateTimeDemo {

    public static void main(String[] args) {

        /**
         * Duration for time
         * Period for days
         */
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);


        LocalDate localDate = LocalDate.now();
        int i = localDate.get(ChronoField.DAY_OF_YEAR);
        System.out.println(i);

        /**
         * Sometimes, though, you need to perform advanced operations, such as adjusting a date to the next Sunday,
         * the next working day, or the last day of the month. In such cases, you can pass to an overloaded
         * version of the with method a TemporalAdjuster that provides a more customizable way to define
         * the manipulation needed to operate on a specific date.
         */
        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextMonday);

        System.out.println(localDate.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.MONDAY)));

        localDate = LocalDate.now().plusDays(1);
        System.out.println(localDate.with(new NextWorkingDay()));

        LocalDate basicIsoDate = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println(basicIsoDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        System.out.println(formattedDate);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
        System.out.println(date2);
    }

    private static class NextWorkingDay implements TemporalAdjuster {

        @Override
        public Temporal adjustInto(Temporal temporal) {
            Temporal temporalTime = temporal.plus(1, ChronoUnit.DAYS);

            while (temporalTime.get(ChronoField.DAY_OF_WEEK) == 6 || temporalTime.get(ChronoField.DAY_OF_WEEK) == 7) {
                temporalTime = temporalTime.plus(1, ChronoUnit.DAYS);
            }
            //temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            return temporalTime;
        }
    }

}
