package com.ajd.prep.dsa.matrix;

import com.ajd.prep.dsa.array.NextBigPermutation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class SudokuValidatorTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        { '6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }, true},
        });
    }

    private SudokuValidator sudokuValidator = new SudokuValidator();
    private char[][] inp;
    private boolean res;

    public SudokuValidatorTest(char[][] inp, boolean res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void isValidTest() {
        boolean got = sudokuValidator.isValid(this.inp);
        assertEquals(res, got);
    }
}
