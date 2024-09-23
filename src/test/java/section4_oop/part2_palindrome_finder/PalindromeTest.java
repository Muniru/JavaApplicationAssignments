package section4_oop.part2_palindrome_finder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    void main1() {
        Palindrome palindrome = new Palindrome();
        String expected = "GGATAGCCGGgTATCC" + System.lineSeparator()+
                ">>>>>>>><<*<<<<<" + System.lineSeparator();
        palindrome.main(new String[]{ "GGATAGCCGGGTATCC"});
        assertEquals(expected, outContent.toString());
    }
    @Test
    void main2() {
        Palindrome palindrome = new Palindrome();
        String expected = "GGATAGCCGGCTATCC" + System.lineSeparator()+
                ">>>>>>>><<<<<<<<" + System.lineSeparator();
        palindrome.main(new String[]{ "GGATAGCCGGCTATCC"});
        assertEquals(expected, outContent.toString());
    }

    @Test
    void main3() {
        Palindrome palindrome = new Palindrome();
        String expected = "GGATAGCCaGGCTATCC" + System.lineSeparator()+
                ">>>>>>>>*<<<<<<<<" + System.lineSeparator();
        palindrome.main(new String[]{ "GGATAGCCAGGCTATCC"});
        assertEquals(expected, outContent.toString());
    }

}