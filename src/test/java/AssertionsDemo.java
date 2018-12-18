import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    @Test
    void standardAssertions() {
        assertEquals(2,2);
        assertEquals(4,4, "parameter string");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated to avoid constructing complex messages unnecesarily");
    }

//    @Test
//    void groupedAssertions() {
//        assertAll("person",
//                () -> assertEquals("John", person.getFirstName()),
//                () -> assertEquals("Doe", person.getLastName()));
//    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(2), () -> {
            System.out.println("time out");
        });
    }

}
