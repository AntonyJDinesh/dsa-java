package com.ajd.prep.dsa.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class StringToIntTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {"5", 5},
                {"55", 55},
                {"-55", -55},
                {"-123456", -123456},
                {"-123456 test", -123456},
                {"Test -123456 test", 0},
                {"123456- test", 123456},
                {"   123456- test", 123456},
                {"2147483648", 2147483647},
                {"-2147483648", -2147483648},

        });
    }

    private StringToInt stringToInt = new StringToInt();
    private int res;
    private String inp;

    public StringToIntTest(String inp, int res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void spiralOrderTest() {
        int got = stringToInt.myAtoi(this.inp);
        log.info("got: {}", got);
        assertEquals(res, got);
    }
}
