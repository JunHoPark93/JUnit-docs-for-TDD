import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionDemo {

    @Test
    void testOnlyOnCiServer() {
        assumeTrue(equals(System.getenv("ENV")), "CI");
    }
}
