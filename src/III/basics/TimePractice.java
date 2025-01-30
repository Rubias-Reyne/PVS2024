package III.basics;

import java.time.Duration;
import java.time.LocalTime;

public class TimePractice {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime lessonStart = LocalTime.of(9,50,0);
        System.out.println(lessonStart);

        //neni casovy interval, proste vezme obecnt casovy format a prevede ho na HH:MM:YYYY
        LocalTime from = LocalTime.from(lessonStart);
//        System.out.println(from);

        LocalTime constants = LocalTime.NOON;
        System.out.println(constants);

        //kolik uplynulo casu od zacatku hodimy
        System.out.println(now.toSecondOfDay() - (lessonStart.toSecondOfDay()));
        System.out.println(now.minusSeconds(lessonStart.toSecondOfDay()));

        //lepsi verze
        System.out.println(Duration.between(from, now));

    }
}
