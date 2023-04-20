import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

// Contains tests for StringArrayProcessor class
class StringArrayProcessorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testMethodProcess() {
        String[] testArray = new String[]{"Bzz", "zzB", "Zzb", "BzZ"};
        StringArrayProcessor.process(testArray);
        String consoleOutput = outputStreamCaptor.toString().trim();
        Assertions.assertEquals("Bzz= 0, 1", consoleOutput);
    }

    @Test
    void testMethodProcessWithEmptyStrings() {
        String[] testArray = new String[]{"", ""};
        StringArrayProcessor.process(testArray);
        String consoleOutput = outputStreamCaptor.toString().trim();
        Assertions.assertEquals("= 0, 1", consoleOutput);
    }

    @Test
    void testMethodProcessWithDataFromTaskDescription() {
        String[] testArray = new String[]{"qwe","wqe","qwee","a","a"};
        StringArrayProcessor.process(testArray);
        String consoleOutput = outputStreamCaptor.toString().trim();
        String[] consoleOutputs = consoleOutput.split("\n");
        Assertions.assertEquals(2, consoleOutputs.length);
        Assertions.assertTrue(Arrays.asList(consoleOutputs).contains("eqw= 0, 1"));
        Assertions.assertTrue(Arrays.asList(consoleOutputs).contains("a= 3, 4"));
    }
}