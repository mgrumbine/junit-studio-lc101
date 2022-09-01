package test;

import org.junit.Test;
import main.BalancedBrackets;

import static org.junit.Assert.*;

public class BalancedBracketsTest {

    //TODO: add tests here
    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    @Test
    public void onlyBracketsReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]"));
    }

    @Test
    public void evenNumberBracketsReturnsTrue(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("[[]]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[[[]]]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[][][][]"));
    }

    @Test
    public void oddNumberBracketsReturnsFalse(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("["));
        assertFalse(BalancedBrackets.hasBalancedBrackets("]"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[]"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[]]]"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[][[][]"));
    }

    @Test
    public void ignoresNonBracketCharacters(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("[LaunchCode]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("Launch[Code]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]LaunchCode"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[LaunchCode"));
    }

    @Test
    public void backwardsBracketsReturnsFalse(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("]["));
        assertFalse(BalancedBrackets.hasBalancedBrackets("Launch]Code["));
    }

    @Test
    public void ignoresNumberCharacters(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("[123456789]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("12345[6789]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]123456789"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[123456789"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("12345]6789["));
    }

    @Test
    public void ignoresSpecialCharacters() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[!@#$%^&*(]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("!@#$%[^&*(]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]!@#$%^&*("));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[!@#$%^&*("));
        assertFalse(BalancedBrackets.hasBalancedBrackets("!@#$%]^&*(["));
    }

    @Test
    public void noBracketsReturnsTrue(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("LaunchCode"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("123456789"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("!@#$%^&*("));
    }

    @Test
    public void emptyStringReturnsTrue(){
        assertTrue(BalancedBrackets.hasBalancedBrackets(""));
    }

    @Test
    public void ignoresCurlyBrackets(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("{}"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("{LaunchCode}"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("Launch{Code}"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("{}LaunchCode"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("{LaunchCode"));
    }

    @Test
    public void ignoresSpaces(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("[Launch Code]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("Launch [Code]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]Launch Code"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[Launch Code"));
    }

}
