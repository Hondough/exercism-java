import org.junit.Test;
import org.junit.Ignore;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RobotTest {

    private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
    private final Robot robot = new Robot();


    @Test
    public void hasName() {
        assertIsValidName(robot.getName());
    }

    @Test
    public void hasAZ0and9() {
        boolean hasA = false;
        boolean hasZ = false;
        boolean has0 = false;
        boolean has9 = false;
        for (int i = 0; i < 100; i++) {
            robot.reset();
            String name = robot.getName();
            assertIsValidName(name);
            hasA |= name.contains("A");
            hasZ |= name.contains("Z");
            has0 |= name.contains("0");
            has9 |= name.contains("9");
        }
        assertTrue("No A present", hasA);
        assertTrue("No Z present", hasZ);
        assertTrue("No 0 present", has0);
        assertTrue("No 9 present", has9);
    }

    @Test
    public void sameRobotRemebersItsName() {
        assertThat(robot.getName(), equalTo(robot.getName()));
        assertIsValidName(robot.getName());
    }

    @Test
    public void differentRobotsHaveDifferentNames() {
        assertThat(robot.getName(), not(equalTo(new Robot().getName())));
    }

    @Test
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        assertThat(name, not(equalTo(name2)));
        assertIsValidName(name2);
    }

    private static void assertIsValidName(String name) {
        assertThat(name.matches(EXPECTED_ROBOT_NAME_PATTERN), is(true));
    }
}
