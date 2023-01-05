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
public class NormalizePathTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {"/../", "/"},
                {"/home//foo/", "/home/foo"},
                {"/home/", "/home"}
        });
    }

    private NormalizePath normalizePath = new NormalizePath();
    private String inp;
    private String res;

    public NormalizePathTest(String inp, String res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void simplifyPathTest() {
        String got = normalizePath.simplifyPath(this.inp);
        assertEquals(res, got);
    }
}
