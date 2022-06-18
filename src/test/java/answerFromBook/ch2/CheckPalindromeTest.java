package answerFromBook.ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckPalindromeTest {

    @Test
    public void questionOne () {
        String str = "tacocat";
        char[] chars = str.toCharArray();

        LinkedList list = new LinkedList();
        for (char c : chars) {
            list.appendToTail(c);
        }
        Assertions.assertEquals(Boolean.TRUE, list.isPalindrome());
    }

    @Test
    public void questionTwo () {
        String str = "atcocta";
        char[] chars = str.toCharArray();

        LinkedList list = new LinkedList();
        for (char c : chars) {
            list.appendToTail(c);
        }
        Assertions.assertEquals(Boolean.TRUE, list.isPalindrome());
    }

    @Test
    public void questionThree () {
        String str = "Tactcoa";
        char[] chars = str.toCharArray();

        LinkedList list = new LinkedList();
        for (char c : chars) {
            list.appendToTail(c);
        }
        Assertions.assertEquals(Boolean.TRUE, list.isPalindrome());
    }

}
