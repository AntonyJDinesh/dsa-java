package com.ajd.prep.dsa.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class ValidParenthesesTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {"{}", true},
                {"()", true},
                {"[]", true},
                {"{[]}", true},
                {"{[]()}", true},
                {"{[]()", false},
        });
    }

    private ValidParentheses validParentheses = new ValidParentheses();
    private String inp;
    private boolean res;

    public ValidParenthesesTest(String inp, boolean res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void evalRPNTest() {
        boolean got = validParentheses.isValid(this.inp);
        assertEquals(res, got);
    }
}
