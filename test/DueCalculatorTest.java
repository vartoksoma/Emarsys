import main.java.DueCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DueCalculatorTest {

    private final DueCalculator calculator = new DueCalculator();

    @Test
    void nextDay(){
        assertEquals("Tuesday 10:00AM",  calculator.calculateDueDate("Monday 10:00AM", 8));
    }

    @Test
    void nexDayPlusOneHour(){
        assertEquals("Tuesday 3:34PM", calculator.calculateDueDate("Monday 2:34PM", 9));
    }

    @Test
    void inTwoDays(){
        assertEquals("Wednesday 11:37AM",  calculator.calculateDueDate("Monday 11:37AM", 16));
    }

    @Test
    void dueToNextWeek(){
        assertEquals("Tuesday 9:12AM",  calculator.calculateDueDate("Monday 9:12AM", 48));
    }

    @Test
    void amToPmChange(){
        assertEquals("Tuesday 1:12PM", calculator.calculateDueDate("Tuesday 11:12AM", 2));

    }


    @Test
    void dueNextMorning(){
        assertEquals("Tuesday 9:11AM", calculator.calculateDueDate("Monday 11:11AM", 6));
    }

}
