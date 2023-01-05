package com.ajd.prep.dsa.stack;

import com.ajd.prep.dsa.array.AdvanceThroughArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class RPNTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22},
                {new String[]{"2","1","+","3","*"}, 9},
                {new String[]{"4","13","5","/","+"}, 6}
        });
    }

    private RPN rpn = new RPN();
    private String[] inp;
    private int res;

    public RPNTest(String[] inp, int res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void evalRPNTest() {
        int got = rpn.evalRPN(this.inp);
        assertEquals(res, got);
    }
}
