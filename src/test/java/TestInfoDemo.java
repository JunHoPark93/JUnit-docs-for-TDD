import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestInfo Demo")
public class TestInfoDemo {
    TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @Test
    @Tag("my-tag")
    @DisplayName("Test1")
    void test1(TestInfo testInfo) {
        assertEquals("Test1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }
}
