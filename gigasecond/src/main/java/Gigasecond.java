import java.time.LocalDate;
import java.time.LocalDateTime;



public class Gigasecond {

    private LocalDateTime time;

    private long gigaSecond = 1000000000L;

    public Gigasecond(LocalDate date) {
        this.time = date.atStartOfDay();
    }

    public Gigasecond(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getDate() {
        return time.plusSeconds(gigaSecond);
    }
}