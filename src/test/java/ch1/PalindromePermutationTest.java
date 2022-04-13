package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromePermutationTest {

    @Test
    public void questionOne () {
        String str = "taco cat";
        Assertions.assertEquals(Boolean.TRUE, PalindromePermutation.answer(str));
    }

    @Test
    public void questionTwo () {
        String str = "atco cta";
        Assertions.assertEquals(Boolean.TRUE, PalindromePermutation.answer(str));
    }

    @Test
    public void questionThree () {
        String str = "Tact Coa";
        Assertions.assertEquals(Boolean.FALSE, PalindromePermutation.answer(str));
    }
}
