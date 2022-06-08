package answerFromBook.ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    public void testOne () {
        LinkedList list = new LinkedList();
        Assertions.assertEquals(Boolean.TRUE, list.isPalindrome());
    }
}
