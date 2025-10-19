package numberrangesummarizer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collection;

public class NumberRangeSummarizerImplementationTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    @Test
    public void testSampleInputFromSpec() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    public void testAllSequentialNumbers() {
        String input = "1,2,3,4,5";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1-5", result);
    }

    @Test
    public void testAllIsolatedNumbers() {
        String input = "1,3,5,7,9";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1, 3, 5, 7, 9", result);
    }

    @Test
    public void testMixedRanges() {
        String input = "1,2,3,5,6,8,10,11,12,13";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1-3, 5-6, 8, 10-13", result);
    }

    @Test
    public void testEmptyInput() {
        String input = "";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("", result);
    }

    @Test
    public void testSingleNumber() {
        String input = "5";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("5", result);
    }

    @Test
    public void testDuplicateNumbers() {
        String input = "1,1,2,2,3,3";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1-3", result);
    }

    @Test
    public void testUnsortedInput() {
        String input = "10,8,9,7,6,5,4";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("4-10", result);
    }

    @Test
    public void testLargeNumbers() {
        String input = "100,101,102,150,200,201,202,203";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("100-102, 150, 200-203", result);
    }
}
