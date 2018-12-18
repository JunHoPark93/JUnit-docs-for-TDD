import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeTestDemo {

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @Test
    void beforeTest() {
        System.out.println("1");
        assertEquals(4,2+2);
    }

    @Test
    void beforeTest2() {
        System.out.println("2");
        assertEquals(5,2+3);
    }
}
