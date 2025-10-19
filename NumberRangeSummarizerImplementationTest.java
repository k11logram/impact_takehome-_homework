/* Testing class for NumberRangeSummarizerImplementation.
We run it on the windows terminal in side the folder using this command:
javac -cp .;junit-platform-console-standalone-1.7.0-all.jar NumberRangeSummarizerImplementationTest.java && java -jar junit-platform-console-standalone-1.7.0-all.jar --class-path . --scan-class-path
*/
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class NumberRangeSummarizerImplementationTest {

    private final NumberRangeSummarizerImplementation summarizer = new NumberRangeSummarizerImplementation();

    @Test
    public void testCollect_NormalInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> expected = List.of(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCollect_EmptyInput() {
        String input = "";
        Collection<Integer> expected = List.of();
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCollect_NullInput() {
        String input = null;
        Collection<Integer> expected = List.of();
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollection_NormalInput() {
        Collection<Integer> input = List.of(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollection_SingleElement() {
        Collection<Integer> input = List.of(5);
        String expected = "5";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollection_EmptyInput() {
        Collection<Integer> input = List.of();
        String expected = "";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }
}