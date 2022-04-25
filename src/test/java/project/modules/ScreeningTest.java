package project.modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScreeningTest {
    Screening test;
    Screening test2;
    Movie movie;
    Movie movie2;
    Theatre theatre;
    Theatre theatre2;

    @BeforeEach
    public void setup() {
        movie = new Movie("The Imitation Game", 8);
        movie2 = new Movie("Ex Machina", 8);
        theatre = new Theatre("Test", 50);
        theatre2 = new Theatre("Test2", 50);
        test = new Screening(movie, 0, theatre);
        test2 = new Screening(movie2, 10, theatre2);
    }
    
    @Test
    public void testConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Screening(movie, -1, theatre);
        });
    }

    @Test
    public void testMethods() {
        Assertions.assertEquals(test, Screening.findScreening(movie, "12:00 - 14:00"));
        Assertions.assertEquals(test2, Screening.findScreening(movie2, "14:30 - 16:30"));
       
        test.setSeats(3);
        Assertions.assertEquals(47, test.getSeats().size());
        Assertions.assertEquals(movie, test.getMovie());

        Assertions.assertEquals(50, test2.getSeats().size());
    }
}
