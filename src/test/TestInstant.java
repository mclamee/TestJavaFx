package test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TestInstant {
    
    static Clock clock;
    
    public static void main(String[] args) {
        Instant time = Instant.now();
        time = time.plus(Duration.ofDays(5).plusDays(2).plusHours(11).plusMinutes(33));
        time = time.minus(Period.ofDays(365));
        System.out.println(time);
        
        Instant time2 = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(time2);
        
        long seconds = time.until(time2, ChronoUnit.DAYS);
        System.out.println(seconds);
        
        Instant time3 = Instant.parse("2011-07-11T05:31:25.174Z");
        System.out.println(time3);
        
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.plus(Period.ofMonths(2)));
        
        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt);
//        lt.atZone(ZoneId.of("EST"));
        System.out.println(lt.plus(Period.ofMonths(2).plusYears(5)));
        System.out.println(lt.get(ChronoField.AMPM_OF_DAY));
        System.out.println(lt.minus(Duration.ofHours(12)).get(ChronoField.AMPM_OF_DAY));
        System.out.println(lt.format(DateTimeFormatter.ISO_INSTANT));
        
//        ZoneId.getAvailableZoneIds().stream().forEach(s -> System.out.println(s));
    }
}
