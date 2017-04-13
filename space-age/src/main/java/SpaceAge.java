
public class SpaceAge {

    private enum Planet {
        MERCURY (0.2408467),
        VENUS (0.61519726),
        EARTH (1.0),
        MARS (1.8808158),
        JUPITER (11.862615),
        SATURN (29.447498),
        URANUS (84.016846),
        NEPTUNE (164.79132);

        private static final long earthYearInSeconds = 31557600L;

        private final double orbitalPeriod;
        Planet (double orbitalPeriod) {
            this.orbitalPeriod = orbitalPeriod;
        }

        public double age(long seconds) {
            return (double) seconds / earthYearInSeconds / orbitalPeriod;
        }
    }

    private long ageInSeconds;

    public long getSeconds() {
        return ageInSeconds;
    }

    public SpaceAge(long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public double onEarth() {
        return Planet.EARTH.age(ageInSeconds);
    }

    public double onMercury() {
        return Planet.MERCURY.age(ageInSeconds);
    }

    public double onVenus() {
        return Planet.VENUS.age(ageInSeconds);
    }

    public double onMars() {
        return Planet.MARS.age(ageInSeconds);
    }

    public double onJupiter() {
        return Planet.JUPITER.age(ageInSeconds);
    }

    public double onSaturn() {
        return Planet.SATURN.age(ageInSeconds);
    }

    public double onUranus() {
        return Planet.URANUS.age(ageInSeconds);
    }

    public double onNeptune() {
        return Planet.NEPTUNE.age(ageInSeconds);
    }
}