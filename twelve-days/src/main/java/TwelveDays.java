public class TwelveDays {
    private enum DayOfChristmas {
        FIRST("first", "a Partridge in a Pear Tree"),
        SECOND("second", "two Turtle Doves"),
        THIRD("third", "three French Hens"),
        FOURTH("fourth", "four Calling Birds"),
        FIFTH("fifth", "five Gold Rings"),
        SIXTH("sixth", "six Geese-a-Laying"),
        SEVENTH("seventh", "seven Swans-a-Swimming"),
        EIGHTH("eighth", "eight Maids-a-Milking"),
        NINTH("ninth", "nine Ladies Dancing"),
        TENTH("tenth", "ten Lords-a-Leaping"),
        ELEVENTH("eleventh", "eleven Pipers Piping"),
        TWELTH("twelth", "twelve Drummers Drumming");

        private String name;
        private String verse;

        private String startOfVerse1 = "On the ";
        private String startOfVerse2 = " day of Christmas";
        private DayOfChristmas(String name, String verse) {
            this.name = name;
            this.verse = verse;
        }

        public String verse(DayOfChristmas day) {

        }
    }
}