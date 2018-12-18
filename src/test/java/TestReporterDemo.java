import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;


public class TestReporterDemo {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a status message");
    }

    @Test
    void reportKeyValuePark(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }
}
