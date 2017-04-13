import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Meetup {

    private int year;
    private int month;
    private static final int FIRST_TEENTH = 13;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day (DayOfWeek dow, MeetupSchedule schedule) {

        TemporalAdjuster adjuster = TemporalAdjusters.nextOrSame(dow);
        int week = 1;

        switch (schedule) {
            case TEENTH:
                break;
            case FOURTH:
                week++;
            case THIRD:
                week++;
            case SECOND:
                week++;
            case FIRST:
                adjuster = TemporalAdjusters.dayOfWeekInMonth(week, dow);
                break;
            case LAST:
                adjuster = TemporalAdjusters.dayOfWeekInMonth(-1, dow);
                break;
        }
        // day of the month needs to be set to the first teenth day.
        // so that we can use nextOrSame.
        return LocalDate.of(year, month, FIRST_TEENTH).with(adjuster);
    }
}