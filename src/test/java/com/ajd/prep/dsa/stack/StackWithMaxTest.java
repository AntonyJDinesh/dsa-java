package com.ajd.prep.dsa.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class StackWithMaxTest {

    @Test
    public void stackWithMaxTest() {
        // StackWithMax<Integer> stack = new StackWithMax<>();
        StackWithMaxSimple<Integer> stack = new StackWithMaxSimple<>();

        assertThrows(RuntimeException.class, () -> stack.pop());

        stack.push(10);
        assertEquals(10, stack.max());
        stack.push(30);
        assertEquals(30, stack.max());
        stack.push(20);
        assertEquals(30, stack.max());
        stack.push(40);

        assertEquals(40, stack.max());
        assertEquals(40, stack.pop());
        assertEquals(30, stack.max());
        assertEquals(20, stack.pop());
        assertEquals(30, stack.max());
    }
}
